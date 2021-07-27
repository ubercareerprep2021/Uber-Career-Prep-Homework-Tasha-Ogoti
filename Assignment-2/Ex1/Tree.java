
/**
 *
 * @author TashaOgoti
 */
public class Tree {
    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }
    
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public void print(){
        if(root != null){
            printLeft(root);
        }
    }
    public void printLeft(TreeNode leftNode){
        if(leftNode != null){
 
            printLeft(leftNode.left);
        
            if(leftNode.right != null){
                printRight(leftNode.right);
            }
        
            System.out.print(leftNode.data + " ");
            
        }
    }
        
    public void printRight(TreeNode rightNode){
        if(rightNode == null){
            return;
        }

        if(rightNode.left != null){
            printLeft(rightNode.left);
        }
        if(rightNode.right != null){
            printRight(rightNode.right);
        }
        
        System.out.print(rightNode.data + " ");
    }

}

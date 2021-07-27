public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(6, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(17, leftChild, rightChild);
        TreeNode root = new TreeNode(1, left, right);
        Tree tree = new Tree(root);
        tree.print();
    }
    
}

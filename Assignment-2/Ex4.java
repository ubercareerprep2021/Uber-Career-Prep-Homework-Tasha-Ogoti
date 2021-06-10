/**
 *
 * @author TashaOgoti
 */
public class BinarySearchTree {
  private Node root;
  
  
  /**
   * Inserts a key into this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to insert.
   */
  public void insert(int key) {
      Node addNode = new Node();
      addNode.key = key;
      addNode.left = null;
      addNode.right = null;
      
      if(root == null){
          //System.out.println("BST initialized");
          root = addNode;
      }
      else{
          Node temp = root;
          
          Node insertionPoint = root;
          while(temp != null){
              insertionPoint = temp;
              
              if(key < temp.key){
                  temp = temp.right;
              }
              else if(key > temp.key){
                temp = temp.left;
              }
              
          }
          if(key < insertionPoint.key){
              insertionPoint.right = addNode;
          } 
          else{
              insertionPoint.left = addNode;
          }
      }
      
    
  }

  /**
   * Checks whether or not a key exists in this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to check for.
   * @return true if the key is present in this binary search tree, false otherwise.
   */
  public boolean find(int key) {
    if(root !=  null){
        Node temp = root;
          
        while(temp != null){
            if(key < temp.key){
                temp = temp.right;
            }
            else if(key > temp.key){
                temp = temp.left;
            }
            else if(key == temp.key){
                return true;
            }
              
        }
    }
    return false;
  }

  public static class Node {
    public int key;
    public Node left;
    public Node right;
  }
}


/**
 *
 * @author TashaOgoti
 */
public class BinarySearchTreePhonebook implements Phonebook{
    private Node root;
  
    private Integer size = 0;
    
    //Used to set the phoneNumber after recursively going through the Binary Search Tree 
    private long foundName = -1L;
    
    public static class Node {
        public String name;
        public long phoneNumber;
        public Node left;
        public Node right;
    }

    
    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        size++;
        Node addNode = new Node();
        addNode.name = name;
        addNode.phoneNumber = phoneNumber;
        addNode.left = null;
        addNode.right = null;
      
      if(root == null){
          System.out.println("BST initialized");
          root = addNode;
      }
      else{
          Node temp = root;
          
          Node insertionPoint = root;
          while(temp != null){
              insertionPoint = temp;
              
              if(phoneNumber < temp.phoneNumber){
                  temp = temp.right;
              }
              else if(phoneNumber > temp.phoneNumber){
                temp = temp.left;
              }
              
          }
          if(phoneNumber < insertionPoint.phoneNumber){
              insertionPoint.right = addNode;
          } 
          else{
              insertionPoint.left = addNode;
          }
      }
    }

    @Override
    public long find(String name) {
        if(root !=  null){
            Node temp = root;
            findNode(temp,name);
        }
        return foundName;
    }
    
    private void findNode(Node node, String name){
        if(node != null){
            if(name.matches(node.name)){
                //System.out.println("\nMATCH -> " + node.phoneNumber);
                foundName = node.phoneNumber;
            }
            else if(!name.matches(node.name)){
                //System.out.println(("Passed through here"));
                findNode(node.right,name);
                findNode(node.left,name);
            }
        }
    }
    
}

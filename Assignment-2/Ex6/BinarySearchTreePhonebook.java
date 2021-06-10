
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author TashaOgoti
 */
public class BinarySearchTreePhonebook {
    private Node root;
  
    private Integer size = 0;
    
    //Used to set the phoneNumber after recursively going through the Binary Search Tree 
    private long foundName = -1L;
    private long startTime;
    private Integer findCalled = 0;
    
    public BinarySearchTreePhonebook(){
        startTime = 0;
    }
    
    public static class Node {
        public String name;
        public long phoneNumber;
        public Node left;
        public Node right;
    }

    
    public int size() {
        return size;
    }

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
     public void readFileToBST(){
        Timer();
        
        try {
            File myPhonebook = new File("data.csv");
            Scanner readData = new Scanner(myPhonebook);
            
            
            while (readData.hasNextLine()) {
                String data = readData.nextLine();
                //System.out.println(data);
                
                String[] phoneBook = data.split(",");
                insert(phoneBook[0],Long.parseLong(phoneBook[1]));
                
            }
            readData.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Insertion time");
        getExecutionTime();
        System.out.println("The total size is: " + size());
    }
    
    public void searchFile(){
        Timer();
        try {
            File myPhonebook = new File("search.txt");
            Scanner readData = new Scanner(myPhonebook);
            
            while (readData.hasNextLine()) {
                String data = readData.nextLine();
                System.out.println(data);
                
                //String[] phoneBook = data.split(",");
                if(find(data) == -1){
                    System.out.println("Find has been called " + findCalled + " times");
                }
                else{
                    findCalled++;
                    System.out.println();
                }
                
            }
            readData.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Search time ");
        getExecutionTime();
    }
    
    public void Timer(){
        startTime = System.currentTimeMillis();
    }
    
    public void getExecutionTime(){
        long endTime = System.currentTimeMillis();
        
        long totalTime = endTime - startTime;
        System.out.print("has taken: " + Long.toString(totalTime)+" ms\n");
    }
    
}

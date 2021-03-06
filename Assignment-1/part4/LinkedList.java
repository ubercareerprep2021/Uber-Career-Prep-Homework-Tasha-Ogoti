import java.util.StringJoiner;

public class LinkedList<T> implements GenericNode<T> {
    
    class Node<T> {
        T value;
        Node next;
        
        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }
    
    Node head;
    Node tail;
    private int size;

    public void push(T t) {
        Node<T> current = new Node<>(t);
        
        //If there is no Node in the list
        if (isEmpty()){
            head = current;
            tail = current;
            size++;
            return;
        }
        //Else add the new node to the end of the list
        tail.next = current;
        tail = current;
        size++;
    }

    //Removes the last node at the end of the linked list and returns data
    public T pop() {
        T val;
        
        //If list is empty 
        if (isEmpty()) {
          throw new NullPointerException("List is empty");
        }

        //Else if only one node exists, the head and tail are set to null
        else if (size() == 1) {
          val = head.value;
          head = null;
          tail = null;
          size = 0;
        }

        // if size of list is greater than one
        else {
          // At least 2 elements
          Node temp = head;
          // Go to second last element
          while (temp.next.next != null)  {
                temp = temp.next;
            }
           if(tail == temp.next){
                tail = temp;
            }
           val = temp.next.value; // Assign the value of the last node
           temp.next = null; // set second last node to null
           tail = temp; // set tail to the second last node
           size--;
          }
          return val;
    }
    
    public void insert(int index, T t) {
        //If the index is greater than size, exit function
        if (index > size()) {
          return;
        }

        Node<T> newNode = new Node<>(t);
        
        //List is empty, exit function
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        //Inserting node to the head
        if (index == 0) {
          newNode.next = head;
          head = newNode;
        } 
        
        //Inserting node at the tail 
        else if (index == (size()-1)) {
          tail.next = newNode;
          tail = newNode;
        }
        
        else {
          int currIdx = 0; // Keep track of the index as we iterate to get to the spot before the index required
          Node currNode = head;

          while (currIdx < index - 1) {
            currIdx++;
            currNode = currNode.next;
          }

          newNode.next = currNode.next;
          currNode.next = newNode;
        }

    }
    
    public void remove(int index) {

      if (index > size() || index < 0 || isEmpty()) {
        return;
      }
      
      if (size() == 1){
        head = null;
        tail = null;
        return;
      }
      
      else{
        int currIdx = 0;
        Node currNode = head;

        while (currIdx < index - 1) {
          currIdx++;
          currNode = currNode.next;
        }
        Node deleteNode = currNode.next;
        currNode.next = deleteNode.next;
        deleteNode.next = null;
        deleteNode = null;
      }
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void printList() {
       if (isEmpty()) {
          System.out.println("()");
       } else {
          StringJoiner joiner = new StringJoiner(",");

          Node curr = head;
          while (curr != null) {
             joiner.add(curr.value.toString());
             curr = curr.next;
          }

          System.out.println("(" + joiner.toString() + ")");
       }  
    }
    
    public int size() {
        return size;
    }
    
    //BONUS: Made an attempt
    public boolean isPalindrome(){
        System.out.print(size());
       if(size() == 2){
           System.out.print("Size == 2");
           return true;
       }
       if(size() > 2){
           ArrayList<Node> addresses = new ArrayList<>();
           Node currNode = head;
           while (currNode != null){
               addresses.add(currNode);
               currNode = currNode.next;
           }
           Integer mid = size()/2;
           mid = mid + 1;
           Integer front = 0;
           Integer back = size();
           while(front < mid){
               System.out.println("Check");
               if( ! addresses.get(front).value.equals(addresses.get(back).value)){
                   System.out.println(addresses.get(front).value);
                   System.out.println(addresses.get(back).value);
                   return false;
               }
               front++;
               back--;
           }
           return true;
       }
       return false;
       
    }
    
    
    
    

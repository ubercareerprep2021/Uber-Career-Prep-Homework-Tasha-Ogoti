import java.util.ArrayList;
import java.util.StringJoiner;

/**
 *
 * @author TashaOgoti
 * @param <T>
 */
public class LinkedList <T> implements GenericNode{
    
    class Node<T>{
        T value;
        Node next;
        
        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }
    
    Node head;
    Node tail;
    private int size=1;
    
    //Adds a single node to the end of the list
    @Override
    public void push(Object t) {
        Node<T> current = new Node<>((T) t);
        if(isEmpty()){
            head = current;
            tail = current;
            return;
        }
        tail.next = current;
        tail = current;
        size++;
    }

    //Removes the last node at the end of the linked list and returns data
    @Override
    public T pop() {
        T val;
        
        //If list is empty 
        if (isEmpty()) {
          throw new NullPointerException("List is empty");
        }

        //Else if only one node exists, the head and tail are set to null
        else if (size() == 1) {
          val = (T) head.value;
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
           /*if(tail == temp.next){
                tail = temp;
            }*/
           val = (T)temp.next.value; // Assign the value of the last node
           temp.next = null; // set second last node to null
           tail = temp; // set tail to the second last node
           size--;
         }
        return val;
    }

    @Override
    public void insert(int index, Object t) {
        if (index > size()) {
        return;
      }

        Node<T> newNode = new Node<>((T)t);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        if (index == 0) {
          newNode.next = head;
          head = newNode;
        } 
        
        else if (index == (size()-1)){
          tail.next = newNode;
          tail = newNode;
        }

        else {
          int currIdx = 0;
          Node currNode = head;

          while (currIdx < index - 1) {
            currIdx++;
            currNode = currNode.next;
          }

          newNode.next = currNode.next;
          currNode.next = newNode;
        }

    
    }

    @Override
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

    @Override
    public int size() {
        return size;
    }

    @Override
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
    
    @Override
    public boolean isEmpty() {
        return (head==null);
    }
    
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
    
    public LinkedList<T> reverseList(LinkedList<T> t){
        if (size() <= 1){
            t.printList();
        }
        
        ArrayList<T> reverseValues = new ArrayList<>();
        Integer limit = 0;
        Node trackReverse = t.head;
        
        //Fill an array with the values
        while(limit != size()){
            reverseValues.add((T)trackReverse.value);
            trackReverse = trackReverse.next;
            limit++;
        }
        
        //Loop through as the list is filled
        limit = reverseValues.size();
        LinkedList <T> reversedList = new LinkedList<>();
        while(limit>0){
            reversedList.push(reverseValues.get(limit-1));
            limit --;
        }
        
        return reversedList;
    }
    
    public LinkedList<T> reverseStack(LinkedList<T> t){
        //Initialize a stack to store values in LinkedList
        LinkedStack<T> stack = new LinkedStack<>();
        
        
        Node temp = t.head;
        
        //Fill up the stack
        while(temp != null){
            stack.push((T)temp.value);
            temp = temp.next;
        }
        
        //List to be filled with the values popped from the stack       
        LinkedList<T> list = new LinkedList<>();
        while(!stack.isEmpty()){
            list.push(stack.pop());
            System.out.print(stack.pop()+" ");
        }
        return list;
    }
    
    public LinkedList reverse(){
        Node temp = reverseRecursively(head);
        LinkedList reverseList = new LinkedList<>();
        
        while(temp != null){
            reverseList.push(temp.value);
            temp = temp.next;
        }
        return reverseList;
    }
    
    public Node reverseRecursively(Node<T> t){
        if(t.next == null || t == null){
            return t;
        }
        
        Node reverse = reverseRecursively(t.next);
        
        t.next.next = t;
        t.next = null;
        
        return reverse;
    }
}

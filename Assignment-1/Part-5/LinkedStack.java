public class LinkedStack <T> {
    
    private Node head;
    private int size;
    
    private class Node{
        T value;
        Node next;
    }
    
    public LinkedStack(){
        head = null;
        size = 0;
    }

    public T pop() {
        T temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    
    public void push(T t) {
        Node previous = head;
        head = new Node();
        head.value = t;
        head.next = previous;
        size++;
    }

    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int size() {
        return size;
    }
    
}

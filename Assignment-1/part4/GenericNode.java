public interface GenericNode<T>{
    void push(T t);
    T pop();
    void insert(int index, T t);
    void remove(int index);
    int size();
    void printList();
    boolean isEmpty();
}

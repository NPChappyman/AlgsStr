package Tree;

public class Node<T extends Comparable<T> , K> {
    T iData; // Данные, используемые в качестве ключа
    K key;
    public Node(T d,K k)
    {
        key = k ;
        iData = d;
    }
    public Node()
    {

    }
    public Node<T,K> leftChild; // Левый потомок узла
    public Node<T,K> rightChild; // Правый потомок узла
    public void displayNode()
    {
        System.out.println(iData);
    }
}

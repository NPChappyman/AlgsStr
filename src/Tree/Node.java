package Tree;

public class Node {
    int iData; // Данные, используемые в качестве ключа
    Node leftChild; // Левый потомок узла
    Node rightChild; // Правый потомок узла
    public void displayNode()
    {
        System.out.println(iData);
    }
}

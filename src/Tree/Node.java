package Tree;

public class Node {
    int iData; // Данные, используемые в качестве ключа
    char key;
    public Node(char k, int d)
    {
        key = k ;
        iData = d;
    }
    public Node()
    {

    }
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла
    public void displayNode()
    {
        System.out.println(iData);
    }
}

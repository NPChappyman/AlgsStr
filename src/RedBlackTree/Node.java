package RedBlackTree;

public class Node<T extends Comparable<T>,K>{
    T key;
    K value;
    Node left=null;
    Node right = null ;
    Color color = Color.BLACK;
    Node parent = null;
    static Node nil= new Node();
    public Node(T key , K value)
    {
        this.key = key;
        this.value = value;
        this.color =Color.RED;
        this.left =  nil;
        this.right = nil;
        this.parent = nil;

    }
    public Node()
    {

    }
}

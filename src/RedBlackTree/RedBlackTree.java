package RedBlackTree;

import java.util.Stack;

// Java Program implement
// Red-Black Tree
enum Color{
    RED,BLACK
}
class Node<T extends Comparable<T>,K>{
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

public class RedBlackTree<T extends Comparable<T>,K>
{
    public Node<T,K> root = Node.nil;
    public K get(T key)
    {
        if (root == Node.nil) return null;
        else
        {
            Node<T,K> currentNode = this.root;

            while (currentNode != Node.nil) {
                int cmp = key.compareTo(currentNode.key); // Сравниваем ключи

                if (cmp < 0) {
                    currentNode = currentNode.left; // Идем влево
                } else if (cmp > 0) {
                    currentNode = currentNode.right; // Идем вправо
                } else {
                    return currentNode.value; // Ключ найден, возвращаем значение
                }
            }
            return null; // Ключ не найден, возвращаем null
        }
    }

    void insert(T key, K value)
    {
        Node<T,K> currentNode = this.root;
        Node<T,K> parrent = Node.nil;
        while (nodeExists(currentNode)){
            parrent = currentNode;
            int cmp = key.compareTo(currentNode.key);
            if (cmp<0) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
        Node newNode = new Node();
        createNode(newNode,key,value);
        newNode.parent = parrent;
        if (parrent == Node.nil) root = newNode;
        else if (key.compareTo( parrent.key) < 0) parrent.left = newNode;
        else parrent.right = newNode;
        balanceTree(newNode);

    }
    void balanceTree( Node<T,K> node)
    {

        Node<T,K> uncle ;
            while (node.parent.color==Color.RED)
            {
                if (node.parent == node.parent.parent.left)
                {
                    uncle = node.parent.parent.right;
                    if (uncle.color == Color.RED)
                    {
                        uncle.color= Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        node.parent.color = Color.BLACK;
                        node= node.parent.parent;

                    }
                    else {

                        if (node == node.parent.right){
                            node = node.parent;
                            rotateLeft(node);
                        }
                        node.parent.color = Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        rotateRight(node.parent.parent);
                    }
                }
                else {
                    uncle = node.parent.parent.left;
                    if (uncle.color == Color.RED)
                    {
                        uncle.color= Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        node.parent.color = Color.BLACK;
                        node= node.parent.parent;
                    }
                    else{
                        if (node == node.parent.left){
                            node = node.parent;
                            rotateRight(node);
                        }
                        node.parent.color =Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        rotateLeft(node.parent.parent);
                    }
                }
            }
        root.color = Color.BLACK;


    }
    // this function performs left rotation
    Node<T,K> rotateLeft(Node<T,K> node) {
        Node<T,K> x = node.right;
        node.right = x.left; // Изменение ссылки на левое поддерево x
        if (x.left != Node.nil) {
            x.left.parent = node; // Обновляем родителя
        }
        x.parent = node.parent; // Обновляем родителя x
        if (node.parent == Node.nil) {
            root = x; // Если node был корнем, обновляем корень
        } else if (node == node.parent.left) {
            node.parent.left = x; // Обновляем ссылку родителя
        } else {
            node.parent.right = x;
        }
        x.left = node; // Вращение
        node.parent = x; // Обновляем родителя
        return x;
    }

    Node<T,K> rotateRight(Node<T,K> node) {
        Node<T,K> x = node.left;
        node.left = x.right; // Изменение ссылки на правое поддерево x
        if (x.right != Node.nil) {
            x.right.parent = node; // Обновляем родителя
        }
        x.parent = node.parent; // Обновляем родителя x
        if (node.parent == Node.nil) {
            root = x; // Если node был корнем, обновляем корень
        } else if (node == node.parent.right) {
            node.parent.right = x; // Обновляем ссылку родителя
        } else {
            node.parent.left = x;
        }
        x.right = node; // Вращение
        node.parent = x; // Обновляем родителя
        return x;
    }
    boolean nodeExists(Node<T,K> node)
    {
        return node!= Node.nil;
    }
    void createNode(Node<T,K> node , T key, K value)
    {
        node.parent = Node.nil;
        node.left=Node.nil;
        node.right= Node.nil;
        node.key =  key;
        node.value= value;
        node.color = Color.RED;
    }

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(isRowEmpty==false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');
            while(globalStack.isEmpty()==false)
            {
                Node temp = (Node)globalStack.pop();
                if( temp!=null && temp != Node.nil)
                {
                    System.out.print(temp.key);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(" ");
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println(
                "......................................................");
    }

    private void preOrderHelper(Node<T,K> node) {
        if (node != Node.nil) {
            System.out.print(node.key + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }
    public void preorder() {
        preOrderHelper(this.root);
    }

    // Inorder traversal helper function
    private void inOrderHelper(Node<T,K> node) {
        if (node != Node.nil) {
            inOrderHelper(node.left);
            System.out.print(node.key + " ");
            inOrderHelper(node.right);
        }
    }

    // Function to start inorder traversal
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Postorder traversal helper function
    private void postOrderHelper(Node<T,K> node) {
        if (node != Node.nil) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.key + " ");
        }
    }

    // Function to start postorder traversal
    public void postorder() {
        postOrderHelper(this.root);
    }


    // Main function to test the Red-Black Tree implementation
    public static void main(String[] args) {
            RedBlackTree<Integer,Integer> tr1= new RedBlackTree<Integer,Integer>();
        tr1.insert(55,1);


        tr1.insert(75,233);

        tr1.insert(121,1);
        tr1.insert(112,1);
        tr1.insert(183,1);
        tr1.insert(323,1);
        tr1.insert(325,1);
        tr1.insert(326,11);
        tr1.insert(328,1);
        tr1.insert(329,1);
        tr1.insert(330,1);
        tr1.insert(331,1);
        tr1.insert(332,1);
        tr1.insert(333,1);tr1.insert(334,1);tr1.insert(336,1);tr1.insert(337,1);
        tr1.insert(338,1);
        System.out.println(tr1.get(326));


    tr1.displayTree();


    }
}
package Tree;
import java.io.*;
import java.util.*;
public class Tree<T extends Comparable<T>, K>
{
    private Node<T,K> root; // Единственное поле данных
    public Node<T,K> getroot()
    {
        return root;
    }
    public void setroot(Node<T,K> w)
    {
        root= w;
    }
    public Node<T,K> find(T key) // Поиск узла с заданным ключом
    { // (предполагается, что дерево не пустое)
        Node<T,K> current = root; // Начать с корневого узла
        while(current.iData != key) // Пока не найдено совпадение
        {
            if(key.compareTo( current.iData)<0) // Двигаться налево?
                current = current.leftChild;
            else
                current = current.rightChild; // Или направо?
            if(current == null) // Если потомка нет,
                return null; // поиск завершился неудачей
        }
        return current; // Элемент найден
    }
    public void insert(T id)
    {
        Node<T,K> newNode = new Node(); // Создание нового узла
        newNode.iData = id; // Вставка данных

        if(root==null) // Корневой узел не существует
            root = newNode;
        else // Корневой узел занят
        {
            Node<T,K> current = root; // Начать с корневого узла
            Node<T,K> parent;
            while(true) // (Внутренний выход из цикла)
            {
                parent = current;
                if(id.compareTo( current.iData)<0) // Двигаться налево?
                {
                    current = current.leftChild;
                    if(current == null) // Если достигнут конец цепочки
                    { // вставить слева
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else // Или направо?
                {
                    current = current.rightChild;
                    if(current == null) // Если достигнут конец цепочки,
                    { // вставить справа
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    // -------------------------------------------------------------
    public boolean delete(T key)
    {
        Node<T,K> current = root;
        Node<T,K> parent = root;
        boolean isLeftChild = true;
        while(current.iData.compareTo( key) != 0) // Поиск узла
        {
            parent = current;
            if(key.compareTo( current.iData)<0) // Двигаться налево?
            {
                isLeftChild = true;
                current = current.leftChild;
            }
            else // Или направо?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) // Конец цепочки
                return false; // Узел не найден
        }
        // Удаляемый узел найден
        // Если узел не имеет потомков, он просто удаляется.
        if(current.leftChild==null &&
                current.rightChild==null)
        {
            if(current == root) // Если узел является корневым,
                root = null; // дерево очищается
            else if(isLeftChild)
                parent.leftChild = null; // Узел отсоединяется
            else // от родителя
                parent.rightChild = null;
        }
        // Если нет правого потомка, узел заменяется левым поддеревом
        else if(current.rightChild==null)
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
            // Если нет левого потомка, узел заменяется правым поддеревом
        else if(current.leftChild==null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else // Два потомка, узел заменяется преемником
        {
            // Поиск преемника для удаляемого узла (current)
            Node<T,K> successor = getSuccessor(current);
            // Родитель current связывается с посредником
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // Преемник связывается с левым потомком current
            successor.leftChild=current.leftChild;
            return true;}
        return false;
        }


    // Метод возвращает узел со следующим значением после delNode.
    // Для этого он сначала переходит к правому потомку, а затем
    // отслеживает цепочку левых потомков этого узла.
    private Node<T,K> getSuccessor(Node<T,K> delNode)
    {
        Node<T,K> successorParent = delNode;
        Node<T,K> successor = delNode;
        Node<T,K> current = delNode.rightChild; // Переход к правому потомку
        while(current != null) // Пока остаются левые потомки
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild; // Переход к левому потомку
        }
        // Если преемник не является
        if(successor != delNode.rightChild) // правым потомком,
        { // создать связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }


    public void preOrder(Node<T,K> localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    public void postOrder(Node<T,K> localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void inOrder(Node<T,K> localRoot)
    {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
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
                Node<T,K> temp = (Node<T,K>)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println(
                "......................................................");
    }
// -------------------------------------------------------------


    public Node<T,K> minimum() // Возвращает узел с минимальным ключом
    {
        Node<T,K> current;
        Node<T,K> last = null;
        current = root; // Обход начинается с корневого узла
        while(current != null) // и продолжается до низа
        {
            last = current; // Сохранение узла
            current = current.leftChild; // Переход к левому потомку
        }
        return last;
    }
    // Другие методы

    public static void main(String[] args)
    {
        Tree<Integer,Integer> ww = new Tree<Integer,Integer>();
        ww.insert(23);
        ww.insert(13);
        ww.insert(1231331);
        ww.insert(23121323);
        ww.displayTree();
    }
} // Конец класса Tree

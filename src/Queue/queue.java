package Queue;

public class queue<T> {
    private int maxSize;
    public T[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    public  queue(int s) // Конструктор
    {
        maxSize = s;
        queArray =(T[]) new Object[maxSize];

        front = 0;
        rear = -1;
        nItems = 0;
    }
//--------------------------------------------------------------
public void insert(T j) // Вставка элемента в конец очереди
{
    if(rear == maxSize-1) // Циклический перенос
        rear = -1;
    queArray[++rear] = j; // Увеличение rear и вставка
    nItems++; // Увеличение количества элементов
}
    //--------------------------------------------------------------
    public T remove() // Извлечение элемента в начале очереди
    {
        T temp = queArray[front++]; // Выборка и увеличение front
        if(front == maxSize) // Циклический перенос
            front = 0;
        nItems--; // Уменьшение количества элементов
        return temp;
    }
    //--------------------------------------------------------------
    public T peekFront() // Чтение элемента в начале очереди
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems==0);
    }
//--------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size() // Количество элементов в очереди
    {
        return nItems;
    }
//--------------------------------------------------------------

    public static void main(String[] args)
    {
        queue<String> w  =  new queue<>(10);



    }
}

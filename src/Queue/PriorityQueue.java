package Queue;

public class PriorityQueue<T extends Comparable<T>> {
    // Элементы массива сортируются по значению ключа,
    // от максимумa (0) до минимума (maxSize-1)
    private int maxSize;
    private T[] queArray;
    private int nItems;
    //-------------------------------------------------------------
    public PriorityQueue(int s) // Конструктор
    {
        maxSize = s;
        queArray = (T[]) new Object[maxSize];
        nItems = 0;
    }
//-------------------------------------------------------------
public void insert(T item) // Вставка элемента
{
    int j;
    if(nItems==0) // Если очередь пуста,
        queArray[nItems++] = item; // вставляем в ячейку 0
    else // Если очередь содержит элементы
    {
        for(j=nItems-1; j>=0; j--) // Перебор в обратном направлении
        {
            if( item.compareTo( queArray[j])>0 ) // Если новый элемент больше,
                queArray[j+1] = queArray[j]; // сдвинуть вверх
            else // Если меньше,
                break; // сдвиг прекращается
        }
        queArray[j+1] = item; // Вставка элемента
        nItems++;
    }
} //
    //-------------------------------------------------------------
    public T remove() // Извлечение минимального элемента
    { return queArray[--nItems]; }
    //-------------------------------------------------------------
    public T peekMin() // Чтение минимального элемента
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    { return (nItems == maxSize); }
//-------------------------------------------------------------
}

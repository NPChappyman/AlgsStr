package doublyLinked;

public class DoubleLinkedListIterator<T> {

    private Link<T> current;
    private DoubleLink<T> ourList;

    public DoubleLinkedListIterator(DoubleLink<T> p)
    {
        ourList=p;
        reset();
    }

    public boolean atEnd() // true, если текущим является
    { return (current.next==null); } // последний элемент

    public void reset()
    {
        current = ourList.getFirst();

    }

    public void nextLink() // Переход к следующему элементу
    {

        current = current.next;
    }
    public void previousLink() // Переход к следующему элементу
    {

        current = current.previous;
    }
    //--------------------------------------------------------------
    public Link<T> getCurrent() // Получение текущего элемента
    { return current; }

    public void insertAfter(T dd) // Вставка после
    { // текущего элемента
        Link<T> newLink = new Link<T>(dd);
        if( ourList.isEmpty() ) // Пустой список
        {
            ourList.setFirst(newLink);
            current = newLink;

        }
        else if (current.next == null)
        {
            ourList.last = newLink;
            current.next = newLink;
            newLink.previous = current;
            nextLink();

        }
        else // Список не пуст
        {
            newLink.next = current.next;
            current.next.previous = newLink;
            current.next = newLink;
            newLink.previous = current;
            nextLink(); // Переход к новому элементу
        }
    }
    //--------------------------------------------------------------
    public void insertBefore(T dd) // Вставка перед
    { // текущим элементом
        Link<T> newLink = new Link<T>(dd);
        if(current.previous == null) // В начале списка
        { // (или пустой список)
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        }
        else // Не в начале списка
        {
            newLink.next = current;
            newLink.previous = current.previous;
            current.previous.next = newLink;
            current.previous = newLink;
            current = newLink;
        }
    }
    //--------------------------------------------------------------
    public T deleteCurrent() // Удаление текущего элемента
    {
        T value = current.dData;
        if(current.previous == null) // Если в начале списка
        {
            if (current.next == null)
            {
                ourList.first = null;
                ourList.last = null;
                ourList.setFirst(null);
            }
            else{
            ourList.setFirst(current.next);
            reset();}
        }

        else // Не в начале списка
        {
            current.previous.next = current.next;
            if (!atEnd()){
            current.next.previous = current.previous.next;
            current = current.next;}
            else {
                ourList.last = current;
                reset();
            }


        }
        return value;
    }
}

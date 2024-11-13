package doublyLinked;

public class DoubleLinkedListIterator {

    private Link current;
    private DoubleLink ourList;

    public DoubleLinkedListIterator(DoubleLink p)
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
    public Link getCurrent() // Получение текущего элемента
    { return current; }

    public void insertAfter(long dd) // Вставка после
    { // текущего элемента
        Link newLink = new Link(dd);
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
    public void insertBefore(long dd) // Вставка перед
    { // текущим элементом
        Link newLink = new Link(dd);
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
    public long deleteCurrent() // Удаление текущего элемента
    {
        long value = current.dData;
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

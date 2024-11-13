package LinkedList;

public class LinkList {
    private Link first; // Ссылка на первый элемент списка
    private Link last;                    // -------------------------------------------------------------
    public LinkList() // Конструктор
    {
        first = null; // Список пока не содержит элементов
        last = null;

    }
    // -------------------------------------------------------------
    public boolean isEmpty() // true, если список пуст
    {
        return (first == null);
    }
    // -------------------------------------------------------------
    public Link getFirst()
    {
        return first;
    }
    public void setFirst(Link p)
    {
        if (isEmpty())
            last = p;
        p.next=first;
        first = p;
    }
// Вставка элемента в начало списка
    public void insertFirst(long dd)
    { // Создание нового элемента
        Link newLink = new Link(dd);
        if (isEmpty()) // Если список пуст,
            last = newLink;
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }
    public void insertLast(long dd) // Вставка элемента в конец списка
    {
        Link newLink = new Link(dd); // Создание нового элемента
        if (isEmpty()) // Если список пуст,
            first = newLink; // first --> newLink
        else
            last.next = newLink; // Старое значение last --> newLink
        last = newLink; // newLink <-- last
    }

    public Link deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList()
    {
        Link temp = first;
        temp.displayLink();
        while (temp.next != null)
        {
            temp = temp.next;
            temp.displayLink();
        }
        System.out.println("");
    }
    public ListIterator getIterator() // Получение итератора
    {
        return new ListIterator(this); // Инициализация списком this
    }

    public Link find(long key) // Поиск элемента с заданным ключом
    { // (предполагается, что список не пуст)
        Link current = first; // Начиная с 'first'
        while (current.dData != key) // Пока совпадение не найдено
        {
            if (current.next == null) // Если достигнут конец списка
                return null; // и совпадение не найдено
            else // Если еще остались элементы
                current = current.next; // Перейти к следующему элементу
        }
        return current; // Совпадение обнаружено
    }
    // -------------------------------------------------------------
    public Link delete(long key) // Удаление элемента с заданным ключом
    { // (предполагается, что список не пуст)
        Link current = first; // Поиск элемента
        Link previous = first;
        while (current.dData != key)
        {
            if (current.next == null)
                return null; // Элемент не найден
            else
            {
                previous = current; // Перейти к следующему элементу
                current = current.next;
            }
        } // Совпадение найдено
        if (current == first) // Если первый элемент,
            first = first.next; // изменить first
        else // В противном случае
            previous.next = current.next; // обойти его в списке
        return current;
    }
// -------------------------------------------------------------
}

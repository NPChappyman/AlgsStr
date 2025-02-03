package doublyLinked;

public class DoubleLink<T> {
    public Link<T> first; // Ссылка на первый элемент списка
    public Link<T> last; // Ссылка на последний элемент списка
    // -------------------------------------------------------------
    public DoubleLink() // Конструктор
    {
        first = null; // Список пока не содержит элементов
        last = null;
    }
    // -------------------------------------------------------------
    public DoubleLinkedListIterator getIterator()
    {
        DoubleLinkedListIterator<T> po = new DoubleLinkedListIterator<T>(this);
        return  po;
    }

    public boolean isEmpty() // true, если список пуст
    { return first==null; }
    // -------------------------------------------------------------
    public Link<T> getFirst()
    {
        return first;
    }

    public void setFirst(Link<T> p)
    {
        if (isEmpty()) {
            first = p;
            last = p;
        }
        else{

        p.next = first.next;
        first = p;}
    }

    public void insertFirst(T dd) // Вставка элемента в начало списка
    {
        Link<T> newLink = new Link<T>(dd); // Создание нового элемента
        if( isEmpty() ) // Если список не содержит элементов,
            last = newLink; // newLink <-- last
        else
            first.previous = newLink; // newLink <-- старое значение first
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }
    // -------------------------------------------------------------
    public void insertLast(T dd) // элемент в конец списка
    {
        Link<T> newLink = new Link<T>(dd); // Создание нового элемента
        if( isEmpty() ) // Если список не содержит элементов,
            first = newLink; // first --> newLink
        else
        {
            last.next = newLink; // старое значение last --> newLink
            newLink.previous = last; // старое значение last <-- newLink
        }
        last = newLink; // newLink <-- last
    }
    // -------------------------------------------------------------
    public Link<T> deleteFirst() // Удаление первого элемента
    { // (предполагается, что список не пуст)
        Link<T> temp = first;
        if(first.next == null) // Если только один элемент
            last = null; // null <-- last
        else
            first.next.previous = null; // null <-- старое значение next
        first = first.next; // first --> старое значение next
        return temp;
    }
    // -------------------------------------------------------------
    public Link<T> deleteLast() // Удаление последнего элемента
    { // (предполагается, что список не пуст)
        Link<T> temp = last;
        if(first.next == null) // Если только один элемент
            first = null; // first --> null
        else
            last.previous.next = null; // старое значение previous --> null
        last = last.previous; // старое значение previous <-- last
        return temp;
    }
    // -------------------------------------------------------------
    // Вставка dd в позицию после key
    public boolean insertAfter(T key, T dd)
    { // (предполагается, что список не пуст)
        Link<T> current = first; // От начала списка
        while(current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.next; // Переход к следующему элементу
            if(current == null)
                return false; // Ключ не найден
        }
        Link<T> newLink = new Link<T>(dd); // Создание нового элемента
        if(current==last) // Для последнего элемента списка
        {
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        }
        else // Не последний элемент
        {
            newLink.next = current.next; // newLink --> старое значение next
            // newLink <-- старое значение next
            current.next.previous = newLink;
        }
        newLink.previous = current; // старое значение current <-- newLink
        current.next = newLink; // старое значение current --> newLink
        return true; // Ключ найден, вставка выполнена
    }
    // -------------------------------------------------------------
    public Link<T> deleteKey(T key) // Удаление элемента с заданным ключом
    { // (предполагается, что список не пуст)
        Link<T> current = first; // От начала списка
        while(current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.next; // Переход к следующему элементу
            if(current == null)
                return null; // Ключ не найден
        }
        if(current==first) // Ключ найден; это первый элемент?
            first = current.next; // first --> старое значение next
        else // Не первый элемент
            // старое значение previous --> старое значение next
            current.previous.next = current.next;
        if(current==last) // Последний элемент?
            last = current.previous; // старое значение previous <-- last
        else // Не последний элемент
            // Старое значение previous <-- старое значение next
            current.next.previous = current.previous;
        return current; // Возвращение удаленного элемента
    }
    // -------------------------------------------------------------
    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        Link<T> current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        Link<T> current = last; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.previous; // Переход к следующему элементу
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}

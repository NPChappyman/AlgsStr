package LinkedList;

public class Link
{

    public long dData; // Данные
    public Link next; // Следующий элемент в списке
    // -------------------------------------------------------------

    public  Link(long d) // Конструктор
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    {
        System.out.println("{"  + dData + "} ");
    }
} // Конец класса Link
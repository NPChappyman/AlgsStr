package doublyLinked;

public class Link<T> {
    public T dData; // Данные
    public Link next; // Следующий элемент в списке
    public Link previous; // Предыдущий элемент в списке
    // -------------------------------------------------------------
    public Link(T d) // Конструктор
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}

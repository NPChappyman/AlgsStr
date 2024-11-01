package Stack;

public class stack<T> {
    private int maxSize; // Размер массива
    private Object[] stackArray;
    private int top; // Вершина стека
    //------------------------
    public stack(int s) // Конструктор
    {
        maxSize = s; // Определение размера стека
        stackArray = new Object[maxSize]; // Создание массива
        top = -1; // Пока нет ни одного элемента
    }
    //--------------------------------------------------------------
    public void push(T j) // Размещение элемента на вершине стека
    {
        stackArray[++top] = j; // Увеличение top, вставка элемента
    }
    //--------------------------------------------------------------
    public Object pop() // Извлечение элемента с вершины стека
    {
        return stackArray[top--]; // Извлечение элемента, уменьшение top
    }

    //--------------------------------------------------------------
    public Object peek() // Чтение элемента с вершины стека
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull() // True, если стек полон
    {
        return (top == maxSize-1);
    }
    //--------------------------------------------------------------
    // Конец класса StackX
    ////////////////////////////////////////////////////////////////

}

class Reverser
{
    private String input; // Входная строка
    private String output; // Выходная строка
    //--------------------------------------------------------------
    public Reverser(String in) // Конструктор
    { input = in; }
    //--------------------------------------------------------------
    public String doRev() // Перестановка символов
    {
        int stackSize = input.length(); // Определение размера стека
        stack<Character> theStack = new stack<Character>(stackSize); // Создание стека
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j); // Чтение символа из входного потока
            theStack.push(ch); // Занесение в стек
        }
        output = "";
        while( !theStack.isEmpty() )
        {
            char ch = (char) theStack.pop(); // Извлечение символа из стека
            output = output + ch; // Присоединение к выходной строке
        }
        return output;
    }
}
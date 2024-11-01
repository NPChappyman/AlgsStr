package Stack;

public class poiskscobok {
    private String input; // Входная строка
    //--------------------------------------------------------------
    public poiskscobok(String in) // Конструктор
    { input = in; }
    //--------------------------------------------------------------
    public void check() {
        int stackSize = input.length(); // Определение размера стека
        stack<Character> theStack = new stack<Character>(stackSize); // Создание стека
        for (int j = 0; j < input.length(); j++) // Последовательное чтение
        {
            char ch = input.charAt(j); // Чтение символа
            switch (ch) {
                case '{': // Открывающие скобки
                    case '[':
                    case '(':
                        theStack.push(ch); // Занести в стек
                        break;
                    case '}': // Закрывающие скобки
                case ']':
                case ')':
                    if (!theStack.isEmpty()) // Если стек не пуст,
                    {
                        char chx = (char)theStack.pop(); // Извлечь и проверить
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '('))
                            System.out.println("Error: " + ch + " at " + j);
                    } else // Преждевременная нехватка элементов
                        System.out.println("Error: " + ch + " at " + j);
                    break;
                default: // Для других символов действия не выполняются
                    break;
            }
        }
        // В этой точке обработаны все символы
        if (!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }

}

import LinkedList.SortedList;
import doublyLinked.DoubleLink;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4,5};
        System.out.println(Array.array.sortfind(arr,4));

        long[] arr2 = {3,6,2,1,8,7};
        long[] workplace = new long[6];
        Array.sort.recMergeSort(arr2,workplace,0,5);
        for (int i =0 ; i<6;i++) System.out.println(arr2[i]);

//        doublyLinked.DoubleLink theList = new doublyLinked.DoubleLink(); // Создание списка
//        doublyLinked.DoubleLinkedListIterator iter1 = theList.getIterator(); // Создание итератора
//        long value;
//        iter1.insertAfter(20); // Вставка элементов
//        iter1.insertAfter(40);
//        iter1.insertAfter(80);
//
//        while(true)
//        {
//            System.out.print("Enter first letter of show, reset, ");
//            System.out.print("next, get, before, after, delete: ");
//            System.out.flush();
//            char choice = getChar(); // Ввод команды
//            switch(choice)
//            {
//                case 's': // Вывод списка
//                    if( !theList.isEmpty() )
//                        theList.displayForward();
//                    else
//                        System.out.println("List is empty");
//                    break;
//                case 'r': // Возврат к первому элементу
//                    iter1.reset();
//                    break;
//                case '-':
//                    if (!theList.isEmpty() && iter1.getCurrent().previous!=null)
//                    iter1.previousLink();
//                    else
//                        System.out.println("Cant go back");
//                    break;
//                case 'n': // Переход к следующему элементу
//                    if( !theList.isEmpty() && !iter1.atEnd() )
//                        iter1.nextLink();
//                    else
//                        System.out.println("Can’t go to next link");
//                    break;
//                case 'g': // Получение текущего элемента
//                    if( !theList.isEmpty() )
//                    {
//                        value = iter1.getCurrent().dData;
//                        System.out.println("Returned " + value);
//                    }
//                    else
//                        System.out.println("List is empty");
//                    break;
//                case 'b': // Вставка перед текущим элементом
//                    System.out.print("Enter value to insert: ");
//                    System.out.flush();
//                    value = getInt();
//                    iter1.insertBefore(value);
//                    break;
//                case 'a': // Вставка после текущего элемента
//                    System.out.print("Enter value to insert: ");
//                    System.out.flush();
//                    value = getInt();
//                    iter1.insertAfter(value);
//                    break;
//                case 'd': // Удаление текущего элемента
//                    if( !theList.isEmpty() )
//                    {
//                        value = iter1.deleteCurrent();
//                        System.out.println("Deleted " + value);
//                    }
//                    else
//                        System.out.println("Can’t delete");
//                    break;
//                default:
//                    System.out.println("Invalid entry");
//            }
//        }


    }

    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------

    public static int Factorial(int n)
    {
        if (n==0) return 1;
        return n*(n-1);
    }


}

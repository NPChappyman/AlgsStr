
import Queue.PriorityQueue;
import Stack.IntoPost;
import Stack.ParsePost;

import java.util.Scanner;
import java.io.*;
public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] a = new int[] {12,313,141,1,42,2,4144,17};
        Stack.stack<Character> thestack = new Stack.stack<Character>(10);
        Array.sort.bubblesort(a);
        for (int i = 0 ; i<a.length ; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        thestack.push('h');
        thestack.push('e');
        thestack.push('l');
        thestack.push('l');
        thestack.push('o');
        while (!thestack.isEmpty())
        {
            System.out.print(thestack.pop());
            System.out.print(" ");

        }
        String input;
        /*while(true) // поменяй на true
        {
            System.out.print(
                    "Enter string containing delimiters: ");

            input = in.next(); // Чтение строки с клавиатуры
            if( input.equals("") ) // Завершение, если [Enter]
                break;
            // Создание объекта BracketChecker
            Stack.poiskscobok theChecker = new Stack.poiskscobok(input);
            theChecker.check();
        }*/

        Queue.test q = new Queue.test(10);

        System.out.println("");
        q.insert(77);
        q.insert(17);
        q.insert(23);
        q.insert(111);
        while( !q.isEmpty() ) // Извлечение и вывод
        { // всех элементов
            long n = q.remove(); //
            System.out.print(n);
            System.out.print(" ");
        }

        Queue.PriorityQueue q2 = new Queue.PriorityQueue(10);
        q2.insert(17);
        q2.insert(77);
        q2.insert(777);
        q2.insert(1717);
        q2.insert(23);
        q2.insert(12);
        while( !q2.isEmpty() ) // Извлечение и вывод
        { // всех элементов
            long n = q2.remove(); //
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
        Stack.IntoPost o = new Stack.IntoPost("1+7*8*(3+5*9)");
        Stack.ParsePost o2 = new ParsePost(o.doTrans());
        System.out.println(o2.doParse());

    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


}

import LinkedList.SortedList;
import doublyLinked.DoubleLink;
import doublyLinked.DoubleLinkedListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        /*int[] arr = {1,2,3,4,5};
        System.out.println(Array.array.sortfind(arr,4));

        long[] arr2 = {3,6,2,1,8,7};
        long[] workplace = new long[6];
        Array.sort.recMergeSort(arr2,workplace,0,5);
        for (int i =0 ; i<6;i++) System.out.println(arr2[i]);*/
        doublyLinked.DoubleLink wwww = new doublyLinked.DoubleLink();
        doublyLinked.DoubleLinkedListIterator it2 = new DoubleLinkedListIterator(wwww);
        it2.insertAfter(10);
        it2.insertAfter(291);
        it2.insertAfter(7);

        wwww.deleteKey(291);
        wwww.deleteKey(7);

        wwww.deleteKey(10);
        wwww.displayForward();
        System.out.println(power(2,62));
        int[] arr = new int[] {7,1,5,9,2};
        int[] arr1 = new int[arr.length];
        bag(arr,arr1,0,0,14);
        int[] warr = new int[] {90,100,20,60,80,110,120,40,10,30,50,70};
        Array.sort.recQuickSort(warr,0, warr.length-1);
        Array.sort.display(warr, warr.length);

        String[] climbers = {"A", "B", "C", "D", "E"};

        // Размер команды (N)
        int teamSize = 3;

        // Массив для хранения текущей комбинации
        String[] currentCombination = new String[teamSize];

        // Генерация всех сочетаний размера teamSize
        System.out.println("Все возможные команды из " + teamSize + " альпинистов:");
        generateCombinations(climbers, teamSize, 0, currentCombination, 0);


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

    public static long power(long x, int y)
    {
        if (y==1) return x;
        if (y==0) return 1;
        if (y%2==0) return power(x*x,y/2);
        else return power(x*x,y/2)*x;

    }

    public static void bag(int[] a, int[] res, int i, int j, int dif)
    {

        if (dif==0)
        {
            System.out.println(" Bag is full ");
            System.out.println("----------------");
            for (int i11 = 0 ; i11<a.length;i11++)
            {
                System.out.print(" "+ res[i11]+ " ");
            }
            System.out.println("");
            System.out.println("----------------");
            return;
        }
        else if (dif<0 || i>=a.length || j>=res.length ) {res[j-1]=0;res[j]=0;return;}
        else {

        for (int i1=i;i1<a.length;i1++)
        {
            res[j]=a[i1];
            bag(a,res,i1+1,j+1,dif-a[i1]);
        }

        }
    }
    public static void generateCombinations(String[] group, int teamSize, int start, String[] currentCombination, int depth) {
        // Если длина текущей комбинации равна требуемой, выводим её
        if (depth == teamSize) {
            for (int i = 0; i < teamSize; i++) {
                System.out.print(currentCombination[i] + " ");
            }
            System.out.println(); // Переход на новую строку
            return;
        }

        // Перебираем элементы массива group, начиная с индекса start
        for (int i = start; i < group.length; i++) {
            currentCombination[depth] = group[i];  // Добавляем альпиниста в текущую комбинацию
            // Рекурсивно продолжаем добавление альпинистов в комбинацию
            generateCombinations(group, teamSize, i + 1, currentCombination, depth + 1);
        }
    }



}

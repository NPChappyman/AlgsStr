import LinkedList.SortedList;
import doublyLinked.DoubleLink;
import doublyLinked.DoubleLinkedListIterator;
import Tree.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        Tree w1 = new Tree();
//        w1.insert(81);
//        w1.insert(72);
//        w1.insert(86);
//        w1.insert(82);
//        w1.insert(83);
//        w1.insert(89);
//        w1.insert(87);
//        w1.insert(88);
//        w1.displayTree();
//        w1.delete(81);
//        w1.displayTree();
        String t   = "sussie sus simdi dedim";

        Haffman tH = new Haffman();
        String res =tH.enCode("sussie sus simdi dedim");
        System.out.println(res);
        System.out.println(tH.decode(res));
        int[] a  = new int[] {12,23,7,2,1,10,1};
        int[] res1 = new int[10];
        bag(a,res1,0,0,14);
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
        else if (dif<0 || i>=a.length || j>=res.length ) {res[j]=0;return;}
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

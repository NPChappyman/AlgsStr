package Array;

public class sort {
    public static void bubblesort(int[] a)
    {

        for (int i = 0;i<a.length;i++ )
        {
            for (int j = 0; j<a.length-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int [] a)
    {
        int in, out;
        for(out=1; out<a.length; out++) // out - разделительный маркер
        {
            int temp = a[out]; // Скопировать помеченный элемент
            in = out; // Начать перемещения с out
            while(in>0 && a[in-1] >= temp) // Пока не найден меньший элемент
            {
                a[in] = a[in-1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            a[in] = temp; // Вставить помеченный элемент
        }
    }


    public static  void selectionSort(int[] a)
    {
        int out, in, min;
        for(out=0; out<a.length-1; out++) // Внешний цикл
        {
            min = out; // Минимум
            for(in=out+1; in<a.length; in++) // Внутренний цикл
                if(a[in] < a[min] ) // Если значение min больше,
                    min = in; // значит, найден новый минимум
            swap(out, min, a); // swap them
        }
    }

    public static void swap(int one, int two,int[] a)
    {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

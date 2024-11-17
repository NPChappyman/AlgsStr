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

    //-----------------------------------------------------------


    public static void recMergeSort(long[] theArray,long[] workSpace, int lowerBound,
                              int upperBound)
    {
        if(lowerBound == upperBound) // Если только один элемент,
            return; // сортировка не требуется.
        else
        { // Поиск середины
            int mid = (lowerBound+upperBound) / 2;
            // Сортировка нижней половины
            recMergeSort(theArray,workSpace, lowerBound, mid);
            // Сортировка верхней половины
            recMergeSort(theArray,workSpace, mid+1, upperBound);
            // Слияние
            merge(theArray,workSpace, lowerBound, mid+1, upperBound);
        }
    }

    public static void merge(long[] theArray,long[] workSpace, int lowPtr,
                       int highPtr, int upperBound)
    {
        int j = 0; // Индекс в рабочей области
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // Количество элементов
        while(lowPtr <= mid && highPtr <= upperBound)
            if( theArray[lowPtr] < theArray[highPtr] )
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }
//-----------------------------------------------------------

    public static void merge1( int[] arrayA, int sizeA,
                              int[] arrayB, int sizeB,
                              int[] arrayC )
    {
        int aDex=0, bDex=0, cDex=0;
        while(aDex < sizeA && bDex < sizeB) // Ни один из массивов не пуст
            if( arrayA[aDex] < arrayB[bDex] )
                arrayC[cDex++] = arrayA[aDex++];
            else
                arrayC[cDex++] = arrayB[bDex++];
        while(aDex < sizeA) // Массив arrayB пуст,
            arrayC[cDex++] = arrayA[aDex++]; // в arrayA остались элементы
        while(bDex < sizeB) // Массив arrayA пуст,
            arrayC[cDex++] = arrayB[bDex++]; // в arrayB остались элементы
    }
    //-----------------------------------------------------------
    // Вывод содержимого массива
    public static void display(int[] theArray, int size)
    {
        for(int j=0; j<size; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }
//-----------------------------------------------------------


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

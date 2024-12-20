package Array;

public class array
{
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов в массиве
    //-----------------------------------------------------------
    public array(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }
    public boolean find(long searchKey)
    { // Поиск заданного значения
        int j;
        for(j=0; j<nElems; j++) // Для каждого элемента
            if(a[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла
        if(j == nElems) // Достигнут последний элемент?
            return false; // Да
        else
            return true; // Нет
    }
    //-----------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }
    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++) // Поиск заданного значения
            if( value == a[j] )
                break;
        if(j==nElems) // Найти не удалось
            return false;
        else // Значение найдено
        {
            for(int k=j; k<nElems; k++) // Сдвиг последующих элементов
                a[k] = a[k+1];
            nElems--; // Уменьшение размера
            return true;
        }
    }
    //-----------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }
    public static int sfind(int[] ar, int key,int lowercase,int upcase)
    {
        int mid = (upcase+lowercase)/2;
        if (ar[mid]==key) return mid;
        else {
            if (upcase<lowercase) return -1;
            if (ar[mid]>key) return sfind(ar,key,lowercase,mid-1);
            else  return sfind(ar,key,mid+1,upcase);
        }

    }
    public static int sortfind(int[] ar,int y)
    {
        return sfind(ar,y,0,ar.length-1);
    }
//-----------------------------------------------------------
}
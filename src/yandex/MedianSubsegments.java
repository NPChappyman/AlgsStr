package yandex;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class MedianSubsegments {

    public static void main(String[] args) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int maxLength = 0;
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int i =0;
        while(i<n) {
            int current = a[i];
            if (!firstOccurrence.containsKey(current)) {
                firstOccurrence.put(current, i);
                i++;
            } else {
                int start = firstOccurrence.get(current);
                boolean isPerfect = true;
                int length = i - start + 1;

                // Проверяем, является ли маршрут идеальным (симметричным)
                for (int j = 1; j < (length) / 2; j++) {
                    if (a[start + j] != a[i - j]) {
                        isPerfect = false;
                        firstOccurrence.clear();
                        firstOccurrence.put(current, i);
                        i++;
                        break;
                    }
                }
                if (isPerfect)
                {
                    while (a[i]==current && i<n) {i++; length++;}
                }
                if (isPerfect && length > maxLength) {
                    maxLength = length;
                }
            }
        }

        System.out.println(maxLength);


    }

}
class Person{

    String name;    // имя
    int age;        // возраст
    public Person()
    {}
    void displayInfo(){
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }}
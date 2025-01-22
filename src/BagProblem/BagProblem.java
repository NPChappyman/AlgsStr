package BagProblem;

public class BagProblem {
    public static int BagProblem(int[] weights, int[] values, int capacity, int n) {
        // Базовый случай: если нет предметов или емкость рюкзака равна 0
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // Если вес текущего предмета больше, чем оставшаяся емкость рюкзака
        if (weights[n - 1] > capacity) {
            return BagProblem(weights, values, capacity, n - 1);
        } else {
            // Возвращаем максимальное значение между двумя вариантами:
            // 1. Не брать текущий предмет
            // 2. Взять текущий предмет
            return Math.max(
                    BagProblem(weights, values, capacity, n - 1), // Не брать предмет
                    values[n - 1] + BagProblem(weights, values, capacity - weights[n - 1], n - 1) // Взять предмет
            );
        }
    }


    public static void main(String[] args)
    {
        int[] weights = {4, 5, 6, 1}; // веса предметов
        int[] values = {30, 36, 25, 35}; // стоимости предметов
        int capacity = 11; // емкость рюкзака
        int n = values.length; // количество предметов

        int maxValue =BagProblem(weights, values, capacity, n);
        System.out.println("Максимальная стоимость: " + maxValue);
    }
}

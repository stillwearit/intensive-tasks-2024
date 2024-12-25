package com.walking.intensive.chapter3.task11;

import java.util.Scanner;

/**
 * Реализуйте метод getOddSubArraysElementsSum() с учетом условий ниже.
 *
 * <p>Входной параметр метода - массив положительных целых чисел.
 *
 * <p>Возвращаемое значение - сумма элементов всех возможных подмассивов нечетной длины.
 * Подмассивом считается непрерывная последовательность элементов массива.
 *
 * <p>Например:
 *
 * <p>Входные данные: array = [1,4,2,5,3]
 *
 * <p>Подмассивы и суммы их элементов:
 *
 * <ul>
 * <li>[1] = 1
 * <li>[4] = 4
 * <li>[2] = 2
 * <li>[5] = 5
 * <li>[3] = 3
 * <li>[1,4,2] = 7
 * <li>[4,2,5] = 11
 * <li>[2,5,3] = 10
 * <li>[1,4,2,5,3] = 15
 * </ul>
 *
 * <p>Итоговая сумма: 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * <p>Возвращаемое значение: 58
 *
 * <p>Для пустого массива должен возвращаться 0.
 *
 * <p>При наличии любых некорректных данных - например, неположительных элементов входящего массива, метод должен
 * возвращать -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите числа через пробел: ");
        String numbers = in.nextLine();
        in.close();

        String[] arrayNum = numbers.split(" ");
        int[] arrayOfNumbers = new int[arrayNum.length];

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = Integer.parseInt(arrayNum[i]);
        }

        System.out.println(getOddSubArraysElementsSum(arrayOfNumbers));
    }

    static int getOddSubArraysElementsSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (!isValid(array)) {
            return -1;
        }



        return 0;
    }

    static boolean isValid(int[] array) {
        for (int i = 0; i < array.length; i++) {
           if (array[i] < 0)
               return false;
        }
        return true;
    }
}

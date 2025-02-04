package com.walking.intensive.chapter4.task17;

import java.util.Arrays;
import java.util.Random;

/**
 * Смауг, живущий в пещере с золотом, был заперт внутри горы.
 * Чтобы занять свое время, он развлекал себя следующей игрой.
 * Он складывал произвольное количество одинаковых монеток по мешочкам,
 * расставлял их в ряд произвольным образом и придумывал алгоритмы,
 * которыми он будет пользоваться для того, чтобы расставить мешочки в порядке возрастания ценности.
 * Времени было много и у него получилось придумать десятки алгоритмов
 * с целью выбрать лучший, который справится с сортировкой за минимальное количество действий.
 *
 * <p>Сортировка — алгоритм расположения элементов массива по неубыванию (возрастанию, если элементы не повторяются).
 *
 * <p>Создайте два метода сортировки: пузырьком и quicksort. Описание алгоритмов вы найдете ниже.
 *
 * <p>
 * При использовании встроенных методов сортировок, коллекций, Stream API и иного материала,
 * выходящего за рамки пройденного курса, задача не принимается к проверке.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task17 {
    public static void main(String[] args) {
        int[] arr = new int[] {80, 55, 77, 32, 18, 99, 24, 5, 42, 65};
        System.out.println(Arrays.toString(sortByQuicksort(arr)));

        System.out.println(getBenchmarkOn1000());
        System.out.println(getBenchmarkOn10000());
    }


    static int[] sortByBubble(int[] array) {
        if (!isValid(array)) {
            return new int[]{};
        }

        int high = array.length - 1;

        while (high > 0) {
            for (int i = 0; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            high--;
        }

        return array;
    }


    static int[] sortByQuicksort(int[] array) {
        if (!isValid(array)) {
            return new int[]{};
        }

        sortByQuickSort(array, 0, array.length - 1);
        return array;
    }

    static void sortByQuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int middleIndex = left + (right - left) / 2;
        int middle = array[middleIndex];

        int i = left;
        int j = right;

        while (j >= i) {
            while (array[i] < middle) {
                i++;
            }
            while (array[j] > middle) {
                j--;
            }

            if (j >= i) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        if (left < j) {
            sortByQuickSort(array, left, j);
        }
        if (right > i) {
            sortByQuickSort(array, i, right);
        }
    }

    static long getBenchmarkOn1000() {
        Random random = new Random();
        int[] array = new int[1000];

        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(10000);
        }

        if (getTimeForBubble(array) < getTimeForQuickSort(array)) {
            return getTimeForQuickSort(array) - getTimeForBubble(array);
        }

        return getTimeForBubble(array) - getTimeForQuickSort(array);
    }

    static long getBenchmarkOn10000() {
        Random random = new Random();
        int[] array = new int[10000];

        for (int i = 0; i < 10000; i++) {
            array[i] = random.nextInt(100000);
        }

        if (getTimeForBubble(array) < getTimeForQuickSort(array)) {
            return getTimeForQuickSort(array) - getTimeForBubble(array);
        }

        return getTimeForBubble(array) - getTimeForQuickSort(array);
    }

    static boolean isValid(int[] array) {
        return array != null && array.length != 0;
    }

    static long getTimeForBubble(int[] array) {
        long startTime = System.currentTimeMillis();
        sortByBubble(array);

        return System.currentTimeMillis() - startTime;
    }

    static long getTimeForQuickSort(int[] array) {
        long startTime = System.currentTimeMillis();
        sortByQuicksort(array);

        return System.currentTimeMillis() - startTime;
    }
}
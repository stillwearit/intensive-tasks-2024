package com.walking.intensive.chapter4.task17;

import java.util.Arrays;

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
        int[] arr = new int[]{6, 83, 35, 2, 18, 56, 33, 28, 72, 100};
        System.out.println(Arrays.toString(sortByQuicksort(arr)));

    }

    /**
     * Сортировка пузырьком:
     *
     * <ol>
     * <li> Метод заключается в попарном сравнении соседних элементов в массиве слева направо.
     *      Сначала сравнивается 0 и 1 индексы в массиве.
     *      Если значения элемента с 0-м индексом больше элемента с 1-м индексом -
     *      элементы меняются местами.
     * <li> Потом сравниваются 1 и 2 индексы, и так последовательно попарно сравниваются все элементы массива.
     *      При этом максимальный элемент массива окажется самым правым в массиве.
     * <li> Далее массивом будем считать неотсортированную часть массива,
     *      то есть без последнего самого правого элемента.
     * <li> Повторяем шаги 1 и 2 до полной сортировки массива.
     * </ol>
     */
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

    /**
     * Создайте массив случайных целых чисел из 1 000 элементов и сравните время,
     * которое потребуются для каждой из сортировок.
     * Ожидаемое возвращаемое значение - разница в выполнении сортировки в миллисекундах.
     *
     * <p>Для получения текущего UNIX-времени (в миллисекундах) можно использовать `System.currentTimeMillis()`.
     * Время выполнения - разность времени после работы алгоритма и времени до работы алгоритма
     */
    static long getBenchmarkOn1000() {
        // Ваш код
        return 0;
    }

    /**
     * Повторите предыдущие вычисления из метода getBenchmarkOn1000() для массива в 10 000 элементов.
     */
    static long getBenchmarkOn10000() {
        // Ваш код
        return 0;
    }

    static boolean isValid (int[] array) {
        return array != null && array.length != 0;
    }
}

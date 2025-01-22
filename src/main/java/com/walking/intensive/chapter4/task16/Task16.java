package com.walking.intensive.chapter4.task16;

import java.util.Arrays;

/**
 * После завершения интенсива вы достаточно быстро познакомитесь с Java Collection Framework.
 * Это знакомство позволит сильно упростить работу с массивами данных.
 *
 * <p>Но пока этого не произошло - даже типовые операции приходится производить вручную.
 * Эта задача - наглядная тому демонстрация.
 *
 * <p>Удачи!
 *
 * <p>P.S. Обратите внимание: если в методе требуется как-то изменять
 * содержимое массива - метод всегда должен возвращать новый массив.
 * Массивы, передаваемые в параметрах, изменяться не должны.
 * Это связано с тем, что в реальных условиях такой входящий массив может далее
 * использоваться в каких-либо иных расчетах и ожидается, что он будет находиться
 * в своем исходном состоянии.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task16 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int[] arr3 = new int[]{3, 4, 5};
        int[] arr4 = new int[]{};
        int[] arr5 = new int[]{3, 4, 4, 6};

        System.out.println(Arrays.toString(incrementEach(arr1)));
        System.out.println(Arrays.toString(reverse(arr1)));
        System.out.println(Arrays.toString(add(arr1, 5, 22)));
        System.out.println(isContains(arr4, 6));
        System.out.println(getFirstIndex(arr5, 2));
        System.out.println(getLastIndex(arr5, 4));
        System.out.println(Arrays.toString(removeByIndex(arr1, 2)));

    }

    static boolean isEqualSize(int[] arr1, int[] arr2) {
        return !isEmpty(arr1) && arr1.length == arr2.length;
    }


    static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    static int[] incrementEach(int[] arr) {
        if (isEmpty(arr)) {
            return new int[]{};
        }

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] + 1;
        }
        return newArr;
    }


    static int[] multiplyEach(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) && isEmpty(arr2)) {
            return new int[]{};
        }

        int[] result;
        if (arr1.length >= arr2.length) {
            result = new int[arr1.length];
        } else {
            result = new int[arr2.length];
        }

        for (int i = 0; i < result.length; i++) {
            if (i >= arr1.length || i >= arr2.length) {
                result[i] = 0;
            } else {
                result[i] = arr1[i] * arr2[i];
            }
        }
        return result;
    }


    static int[] subtractEach(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) && isEmpty(arr2)) {
            return new int[]{};
        }

        int[] result;
        if (arr1.length >= arr2.length) {
            result = new int[arr1.length];
        } else {
            result = new int[arr2.length];
        }

        for (int i = 0; i < result.length; i++) {
            if (i >= arr1.length) {
                result[i] = -arr2[i];
            } else if (i >= arr2.length) {
                result[i] = arr1[i];
            } else {
                result[i] = arr1[i] - arr2[i];
            }
        }
        return result;
    }


    static int[] reverse(int[] arr) {
        if (isEmpty(arr)) {
            return new int[]{};
        }

        int[] reverse = new int[arr.length];
        int index = arr.length - 1;
        int index2 = 0;
        while (index >= 0 && index2 < arr.length) {
            reverse[index2] = arr[index];
            index--;
            index2++;
        }
        return reverse;
    }


    static int[] add(int[] arr, int index, int newValue) {
        if (index < 0) {
            return new int[]{};
        }

        int[] newArr = new int[arr.length + 1];
        for (int index2 = 0; index2 < newArr.length; index2++) {
            if (index2 < index && index2 < arr.length) {
                newArr[index2] = arr[index2];
            } else {
                newArr[index2] = arr[index2 - 1];
            }
        }
        newArr[newArr.length - 1] = newValue;
        return newArr;
    }


    static boolean isContains(int[] arr, int value) {
        for (int number : arr) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }


    static int getFirstIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    static int getLastIndex(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    static int[] removeByIndex(int[] arr, int index) {
        if (index < 0) {
            return new int[]{};
        }

        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i + 1];
            }
        }
        return newArr;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и
     * еще один массив целых чисел (в виде varargs).
     * И возвращает первый массив, удалив из него все числа, которые есть во втором.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], [20,23,30]
     * <p>Возвращаемое значение: [10,40,50,60]
     */
    static int[] removeAll(int[] arr, int... removingValues) {
        // Ваш код
        return null;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        // Ваш код
        return false;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, сдвинув все элементы входящего массива на следующий индекс.
     * При этом последний элемент будет перенесен на нулевой индекс.
     *
     * <p> Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4]
     * <p>Возвращаемое значение: [4,1,2,3]
     */
    static int[] shiftIndex(int[] arr) {
        // Ваш код
        return null;
    }

    static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }
}

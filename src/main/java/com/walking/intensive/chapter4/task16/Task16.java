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
        int[] arr1 = new int[]{5, 3, 3, 4, 5};
        int[] arr3 = new int[]{1, 2, 3};

        System.out.println(Arrays.toString(multiplyEach(arr1, arr3)));
        System.out.println(Arrays.toString(shiftIndex(arr1)));
        System.out.println(Arrays.toString(add(arr3, 10, 300)));

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

        int[] result = new int[Math.max(arr1.length, arr2.length)];
        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] * arr2[i];
        }

        return result;
    }

    static int[] subtractEach(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) && isEmpty(arr2)) {
            return new int[]{};
        }

        int[] result = new int[Math.max(arr1.length, arr2.length)];
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
        for (int i = 0; i < newArr.length; i++) {
            if (i < index && i < arr.length) {
                newArr[i] = arr[i];
            } else if (i == index) {
                newArr[i] = newValue;
            } else {
                newArr[i] = arr[i - 1];
            }

            if (index >= arr.length) {
                newArr[newArr.length - 1] = newValue;
            }
        }
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
        if (index < 0 || isEmpty(arr)) {
            return new int[]{};
        }
        if (index >= arr.length) {
            return arr;
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

    static int[] removeAll(int[] arr, int... removingValues) {
        if (isEmpty(removingValues)) {
            return arr;
        }

        int length = arr.length;
        for (int i : arr) {
            for (int j : removingValues) {
                if (i == j) {
                    length -= 1;
                    break;
                }
            }
        }

        int[] newArr = new int[length];
        int add = 0;
        for (int i = 0; i < length; i++) {
            for (int j : removingValues) {
                if (arr[i + add] == j) {
                    add += 1;
                }
                newArr[i] = arr[i + add];
            }
        }
        return newArr;
    }

    static boolean isSimilar(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) || isEmpty(arr2)) {
            return false;
        }

        for (int i : arr1) {
            if (!isContains(arr2, i)) {
                return false;
            }
        }

        for (int i : arr2) {
            if (!isContains(arr1, i)) {
                return false;
            }
        }

        return true;
    }

    static int[] shiftIndex(int[] arr) {
        if (isEmpty(arr)) {
            return arr;
        }

        int[] newArr = new int[arr.length];
        newArr[0] = arr[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }
}

package com.walking.intensive.chapter3.task14;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Необходимо разработать программу, которая определяет количество объектов на радарах.
 *
 * <p>Реализуйте метод getObjectCounts(), который произведет указанный расчет.
 *
 * <p>Входящие параметры метода:
 *
 * <ol>
 * <li>Двумерный массив с координатами объектов, где любой objectLocations[i]
 *      содержит массив из двух точек - координат объекта по осям X и по Y соответственно;
 * <li>Двумерный массив с параметрами радаров, где любой radars[j] содержит массив со следующими данными:
 *      radars[j][0] - координата радара по оси X, radars[j][1] - координата радара по оси Y,
 *      radars[j][2] - радиус действия радара
 * </ol>
 *
 * <p>Возвращаемое значение метода - количество объектов, видимых на каждом из радаров:
 * objectCounts[j] должен содержать информацию о числе объектов, видимых на радаре radars[j].
 *
 * <p>Если объект находится точно на границе действия радара, считается,
 * что он попадает в зону действия этого радара.
 *
 * <p>Пример:
 *
 * <p>Входящие параметры: objectLocations[][] = [[1,3],[3,3],[5,3],[2,2]], radars[][] = [[2,3,1],[4,3,1],[1,1,2]].
 *
 * <p>Возвращаемое значение: objectCounts[] = [3,2,2].
 *
 * <p>Пояснение (для radars[0]):
 *
 * <ul>
 * <li>objectCounts[0] = 3, потому что радар с координатами (2;3) и радиусом действия 1 видит объекты с координатами
 * (1;3), (2;2) и (3;3). Всего 3 объекта.
 *</ul>
 *
 * <p>При наличии некорректных входных данных верните из метода пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество объектов: ");
        int objects = in.nextInt();
        int[][] objectsLocation = new int[objects][];

        for (int i = 0; i < objectsLocation.length; i++) {
            System.out.printf("Введите через пробел координаты %d объекта: ", i + 1);
            String coordinates = in.nextLine();
            String[] coordinates1 = coordinates.split(" ");
            int[] coordinates2 = new int[] {parseInt(coordinates1[0]), parseInt(coordinates1[1])};
            objectsLocation[i] = coordinates2;
        }

        System.out.println("Введите количество радаров: ");
        int radarsAmount = in.nextInt();
        int[][] radars = new int[radarsAmount][];

        for (int i = 0; i < radars.length; i++) {
            System.out.printf("Введите через пробел координаты и радиус %d радара: ", i + 1);
            String coordinates = in.nextLine();
            String[] data = coordinates.split(" ");
            int[] radarsData = new int[]{parseInt(data[0]), parseInt(data[1]), parseInt(data[2])};
            radars[i] = radarsData;
        }

        System.out.println(Arrays.toString(getObjectCounts(objectsLocation, radars)));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        // Ваш код
        return new int[0];
    }
}

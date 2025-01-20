package com.walking.intensive.chapter3.task15;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания не может быть отрицательной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
        int[][] city = {{2, 1}, {1, 3}};
        System.out.println(getMaxFloors(city));

        int[][] biggerCity = {{0, 5, 3, 4}, {1, 2, 4, 2}, {3, 3, 5, 6}, {2, 4, 1, 3}};
        System.out.println(getMaxFloors(biggerCity));
    }

    static int getMaxFloors(int[][] city) {
        int maxFloors = 0;

        int[][] biggestBuildings = new int[2][];
        biggestBuildings[0] = new int[city.length];
        biggestBuildings[1] = new int[city.length];

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (biggestBuildings[0][i] < city[i][j]) {
                    biggestBuildings[0][i] = city[i][j];
                }
            }
        }

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (biggestBuildings[1][i] < city[j][i]) {
                    biggestBuildings[1][i] = city[j][i];
                }
            }
        }

        for (int r = 0; r < city.length; r++) {
            for (int c = 0; c < city.length; c++) {
                if (city[r][c] >= biggestBuildings[0][c] || city[r][c] >= biggestBuildings[1][r]) {
                    maxFloors += 0;
                } else if (biggestBuildings[0][c] < biggestBuildings[1][r]) {
                    maxFloors += biggestBuildings[0][c] - city[r][c];
                } else {
                    maxFloors += biggestBuildings[1][r] - city[r][c];
                }
            }
        }

        return maxFloors;
    }

}

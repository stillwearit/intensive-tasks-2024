package com.walking.intensive.chapter1.task5;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Длина первой стороны: ");
        double a = in.nextDouble();
        System.out.print("Длина второй стороны: ");
        double b = in.nextDouble();
        System.out.print("Длина третьей стороны: ");
        double c = in.nextDouble();

        System.out.println("Площадь треугольника: " + getAreaByHeron(a, b, c));
        System.out.println("Высоты треугольника: " + Arrays.toString(getHeights(a, b, c)));
        System.out.println("Медианы треугольника: " + Arrays.toString(getMedians(a, b, c)));
        System.out.println("Биссектрисы треугольника: " + Arrays.toString(getBisectors(a, b, c)));
        System.out.println("Углы треугольника: " + Arrays.toString(getAngles(a, b, c)));
        System.out.println("Радиус вписаной в треугольник окружности: " + getInscribedCircleRadius(a, b, c));
        System.out.println("Радиус описанной вокруг треугольника окружности: " + getCircumradius(a, b, c));
        System.out.println("Площадь треугольника через синус: " + getAreaAdvanced(a, b, c));

    }

    static boolean isTriangleExist (double a, double b, double c) {
        return a < b + c && b < a + c && c < a + b;
    }

    static double getHalfPerimeter (double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getCosC (double a, double b, double c) {
        return (a * a + b * b - c * c) / (2 * a * b);
    }

    static double[] sortArrays (double doubles1, double doubles2, double doubles3) {
        double[] doubles = new double[3];
        if (doubles1 < doubles2 && doubles1 < doubles3)  {
            doubles[0] = doubles1;
        } else if (doubles2 < doubles1 && doubles2 < doubles3) {
            doubles[0] = doubles2;
        } else {
            doubles[0] = doubles3;
        }

        if (doubles1 > doubles2 && doubles1 > doubles3) {
            doubles[2] = doubles1;
        } else if (doubles2 > doubles1 && doubles2 > doubles3) {
            doubles[2] = doubles2;
        } else {
            doubles[2] = doubles3;
        }

        if (doubles[0] != doubles1 && doubles[2] != doubles1) {
            doubles[1] = doubles1;
        } else if (doubles[0] != doubles2 && doubles[2] != doubles2) {
            doubles[1] = doubles2;
        } else {
            doubles[1] = doubles3;
        }

        return doubles;
    }

    static double getAreaByHeron(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {
            double halfPerimeter = getHalfPerimeter(a, b, c);
            return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        }

        return -1;
    }

    static double[] getHeights(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double area = getAreaByHeron(a, b, c);
            double doubles1 = area * 2 / a;
            double doubles2 = area * 2 / b;
            double doubles3 = area * 2 / c;

            return sortArrays(doubles1, doubles2, doubles3);
        }

        return new double[0];
    }

    static double[] getMedians(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double doubles1 = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
            double doubles2 = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
            double doubles3 = Math.sqrt(2 * c * c + 2 * b * b - a * a) / 2;

            return sortArrays(doubles1, doubles2, doubles3);
        }

        return new double[0];
    }

    static double[] getBisectors(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double halfPerimeter = getHalfPerimeter(a, b, c);

            double doubles1 = 2 * Math.sqrt(a * b * halfPerimeter * (halfPerimeter - c)) / (a + b);
            double doubles2 = 2 * Math.sqrt(a * c * halfPerimeter * (halfPerimeter - b)) / (a + c);
            double doubles3 = 2 * Math.sqrt(c * b * halfPerimeter * (halfPerimeter - a)) / (c + b);

            return sortArrays(doubles1, doubles2, doubles3);
        }

        return new double[0];
    }

    static double[] getAngles(double a, double b, double c) {
       if (isTriangleExist(a, b, c)) {

           double cosC = getCosC(a, b, c);
           double cosB = (a * a + c * c - b * b) / (2 * a * c);

           double doubles1 = Math.toDegrees(Math.acos(cosC));
           double doubles2 = Math.toDegrees(Math.acos(cosB));
           double doubles3 = 180 - doubles1 - doubles2;

           return sortArrays(doubles1, doubles2, doubles3);
       }

       return new double[0];
    }

    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double halfPerimeter = getHalfPerimeter(a, b, c);

            return (getAreaByHeron(a, b, c) / halfPerimeter);
        }

        return -1;
    }


    static double getCircumradius(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double cosC = getCosC(a, b, c);
            double sinC = Math.sqrt(1 - cosC * cosC);

            return (c / (2 * sinC));
        }

        return -1;
    }

    static double getAreaAdvanced(double a, double b, double c) {
        if (isTriangleExist(a, b, c)) {

            double cosC = getCosC(a, b, c);
            double sinC = Math.sqrt(1 - cosC * cosC);

            return (a * b / 2 * sinC);
        }

        return -1;
    }
}
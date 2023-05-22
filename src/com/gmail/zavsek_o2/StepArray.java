package com.gmail.zavsek_o2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StepArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків (N): ");
        int n = scanner.nextInt();

        System.out.print("Введіть максимальну кількість елементів в рядку (M): ");
        int m = scanner.nextInt();

        int[][] array = generateStepArray(n, m);

        System.out.println("Початковий ступінчатий масив:");
        printArray(array);

        sortRows(array);
        System.out.println("Відсортований масив:");
        printArray(array);

        int sum = calculateSum(array);
        System.out.println("Сума всіх елементів масиву: " + sum);

        int[] minElements = findMinimumElements(array);
        System.out.println("Мінімальні елементи в кожному рядку: " + Arrays.toString(minElements));

        int absoluteMin = findAbsoluteMinimum(array);
        System.out.println("Абсолютний мінімум: " + absoluteMin);

        divideByMinimum(array, absoluteMin);
        System.out.println("Масив після поділу на абсолютний мінімум:");
        printArray(array);
    }

    public static int[][] generateStepArray(int n, int m) {
        Random random = new Random();
        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            int numElements = random.nextInt(m);
            array[i] = new int[numElements];
            for (int j = 0; j < numElements; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        return array;
    }

    public static void sortRows(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                Arrays.sort(array[i]);
            } else {
                Arrays.sort(array[i]);
                reverse(array[i]);
            }
        }
    }

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    public static int calculateSum(int[][] array) {
        int sum = 0;

        for (int[] row : array) {
            for (int element : row) {
                sum += element;
            }
        }

        return sum;
    }

    public static int[] findMinimumElements(int[][] array) {
        int[] minElements = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }

            minElements[i] = min;
        }

        return minElements;
    }

    public static int findAbsoluteMinimum(int[][] array) {
        int absoluteMin = Integer.MAX_VALUE;

        for (int[] row : array) {
            for (int element : row) {
                if (element < absoluteMin) {
                    absoluteMin = element;
                }
            }
        }

        return absoluteMin;
    }

    public static void divideByMinimum(int[][] array, int divisor) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] /= divisor;
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}



package org.example;

public class Variant1 {
    public int inMeter(int l) {
        return l / 100;
    }
    public boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public int modifyNumber(int number) {
        if (number > 0) {
            number += 1;
        }
        return number;
    }

    public String getDayOfWeek(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "понеділок";
            case 2 -> "вівторок";
            case 3 -> "середа";
            case 4 -> "четвер";
            case 5 -> "п'ятниця";
            case 6 -> "субота";
            case 7 -> "неділя";
            default -> "невідомий день";
        };
    }

    public void printNumberNTimes(int K, int N) {
        if (N <= 0) {
            System.out.print("N має бути більше нуля");
            return;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(K);
        }
    }

    public int findRemainingLength(int A, int B) {
        if (A <= 0 || B <= 0) {
            throw new IllegalArgumentException("Як A, так і B повинні бути позитивними числами.");
        }

        while (A >= B) {
            A -= B;
        }

        return A;
    }

    public int[] generateOddNumbers(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N повинно бути більше 0");
        }

        int[] oddNumbers = new int[N];
        int currentOdd = 1;

        for (int i = 0; i < N; i++) {
            oddNumbers[i] = currentOdd;
            currentOdd += 2;
        }

        return oddNumbers;
    }


    public int[][] createMatrix(int M, int N) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * (i + 1);
            }
        }
        return matrix;
    }


    public int[] findMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        return new int[]{min, max};
    }
}

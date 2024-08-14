package app;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];

        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        printMatrix(matrix);

        int evenRowSum = 0;
        int oddRowSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        int evenColProduct = 1;
        int oddColProduct = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    evenColProduct *= matrix[i][j];
                } else {
                    oddColProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (0, 2): " + evenRowSum + "\nСума елементів у непарних рядках (1, 3): " + oddRowSum
        + "\nДобуток елементів у парних стовпцях (0, 2): " + evenColProduct + "\nДобуток елементів у непарних стовпцях (1, 3): " + oddColProduct ); ;

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int sumDiag1 = 0, sumDiag2 = 0;
        int sumRow, sumCol;
        int targetSum = 0;


        for (int i = 0; i < 4; i++) {
            targetSum += matrix[0][i];
        }

        for (int i = 0; i < 4; i++) {
            sumRow = 0;
            sumCol = 0;
            for (int j = 0; j < 4; j++) {
                sumRow += matrix[i][j];
                sumCol += matrix[j][i];
            }
            if (sumRow != targetSum || sumCol != targetSum) {
                return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            sumDiag1 += matrix[i][i];
            sumDiag2 += matrix[i][3 - i];
        }

        return sumDiag1 == targetSum && sumDiag2 == targetSum;
    }
}

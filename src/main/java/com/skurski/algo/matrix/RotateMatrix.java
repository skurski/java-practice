package com.skurski.algo.matrix;


import java.util.Random;

/**
 * Dany jest rysunek reprezentowany przez macierz o wymiarach N×N, w którym każdy piksel
 * jest reprezentowany za pomocą czterech bajtów. Napisz metodę, która rotuje rysunek
 * o 90 stopni. Czy potrafisz wykonać tę operację w miejscu?
 */
public class RotateMatrix {

    public int[][] create(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; ++i) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int N = 5;
        int[][] matrix = rotateMatrix.create(N, N);
        rotateMatrix.print(matrix);
        System.out.println();

        int[][] rotateM = rotateMatrix.rotate(matrix, N);
        rotateMatrix.print(rotateM);
    }

}

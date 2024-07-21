package arrays_and_strings;

import java.util.Arrays;

class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {0, 2, 3, 4}
        };
        var result = zeroMatrixIdeal(matrix);
//        var result = zeroMatrix(matrix, 4, 4);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] zeroMatrixIdeal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowHasZero = new boolean[m];
        boolean[] columnHasZero = new boolean[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    columnHasZero[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(rowHasZero[i]) {
                zeroRow(matrix, i, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if(columnHasZero[j]) {
                zeroColumn(matrix, j, m);
            }
        }
        return matrix;
    }

    public static int[][] zeroMatrix(int[][] matrix, int m, int n) {
        boolean[][] isZero = new boolean[m][n]; // wasteful
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                isZero[i][j] = matrix[i][j] == 0;
            }
        }
        return zeroMatrixHelper(matrix, isZero, m, n);
    }

    private static int[][] zeroMatrixHelper(int[][] matrix, boolean[][] isZero, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isZero[i][j]) {
                    zero(matrix, i, j, m, n);
                }
            }
        }
        return matrix;
    }

    private static void zero(int[][] matrix, int row, int column, int m, int n) {
        for(int i = 0; i < m; i++) {
            matrix[i][column] = 0;
        }
        for(int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void zeroColumn(int[][] matrix, int column, int m) {
        for(int i = 0; i < m; i++) {
            matrix[i][column] = 0;
        }
    }

    private static void zeroRow(int[][] matrix, int row, int n) {
        for(int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }

}
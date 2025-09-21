package org.utils;

public class MatrixUtils {
    public static int sum(int[][] matrix) {
        int sum = 0;

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                sum += matrix[r][c];
            }
        }

        return sum;
    }
}

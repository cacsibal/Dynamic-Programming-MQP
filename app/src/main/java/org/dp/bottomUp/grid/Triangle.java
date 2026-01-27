package org.dp.bottomUp.grid;
import java.util.Collections;

class Triangle {

    int[][] triangle;

    public Triangle(int[][] triangle){
        this.triangle=triangle;
    }


    public int solution() {

        /**
         * Iterative Solution
         */
        for(int r=1;r<triangle.length;r++){
            for(int c=0;c<triangle[r].length;c++){
                int best = Math.min(c==0?Integer.MAX_VALUE:triangle[r-1][c-1], c==r?Integer.MAX_VALUE:triangle[r-1][c]);
                triangle[r][c]+=best;
            }
        }

        /**
         * Return Max of Bottom
         */
        int min = Integer.MAX_VALUE;
        for(int c=0;c<triangle.length;c++){
            min=Math.min(min,triangle[triangle.length-1][c]);
        }
        return min;
    }
}
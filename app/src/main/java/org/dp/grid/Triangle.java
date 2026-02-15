package org.dp.grid;
import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

import java.util.*;

/**
 * Name: Minimum Sum Path in a Triangle
 * Description:
 * Given a triangular array triangle[], find the minimum path sum from
 * top to bottom. We start from the first cell in the first row, and at
 * each step, we can move to one of the two adjacent cells in the next
 * row — that is, if we are at index i in the current row, we can move
 * to either index i or i + 1 in the next row.
 *
 * The triangular array contains 1 cell in 1st row, 2 cells in 2nd row and so on.
 */
class Triangle implements ITopDown, IBottomUp, IRetrieveSolution {

    int[][] triangle;

    public Triangle(int[][] triangle){
        this.triangle=triangle;
    }


    public int helper_bottomup() {

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

    public int helper_topdown(int r, int c) {
        if(r == triangle.length){
            return 0;
        }

        return triangle[r][c] + Math.min(helper_topdown(r+1, c),
                helper_topdown(r+1, c+1));
    }

    public int compute_sum(ArrayList<Integer> nums){
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }

    public ArrayList<Integer> helper_retrieve(int r, int c){
        if(r == triangle.length-1){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(triangle[r][c]);
            return base;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(triangle[r][c]);
        ArrayList<Integer> thisColumn = helper_retrieve(r+1, c);
        ArrayList<Integer> nextColumn = helper_retrieve(r+1, c+1);

        if(compute_sum(thisColumn) <= compute_sum(nextColumn)){
            result.addAll(thisColumn);
        } else {
            result.addAll(nextColumn);
        }
        return result;
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution_topdown() {
        return helper_topdown(0, 0);
    }

    public int solution() {
        return solution_topdown();
    }

    public int[] retrieve(){
        ArrayList<Integer> ans = helper_retrieve(0,0);
        int[] arr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
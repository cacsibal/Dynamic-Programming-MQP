package BottomUp;
import java.util.Arrays;

// test
public class Main {
    public static void main(String[] args) {
//        System.out.println((new LongestIncreasingSubsequence()).lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

        int[][] out = (new Pascal()).pascal(5);
        for(int[] row : out) {
            System.out.println(Arrays.toString(row));
        }
    }
}
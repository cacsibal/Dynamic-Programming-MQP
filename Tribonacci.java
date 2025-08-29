// Anton

public class Tribonacci {
    public int tribonacci(int n){
        int[] memo = new int[Math.max(n + 1, 3)];

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        for(int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        return memo[n];
    }
}

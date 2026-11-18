class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for(int len = 2; len < 2 + n; len++){
            for(int i = 0; i < n + 2 - len; i++){
                int j = i + len;
                for(int k = i + 1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][k] + dp[k][j] + newNums[k] * newNums[i] * newNums[j],dp[i][j]);

                }
            }
        }
        return dp[0][n + 1];
    }
}

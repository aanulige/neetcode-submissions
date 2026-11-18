class Solution {
    public int countSubstrings(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        boolean[][] dp = new boolean[n][n];

        int res = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}

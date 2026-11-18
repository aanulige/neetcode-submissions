class Solution {
    public int numDecodings(String str) {
        char[] s = str.toCharArray();
        int n = s.length;

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--){
            if(s[i] == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i + 1];

                // 1 2 0 1 2
                if((i + 1 < n && (s[i] - '0') * 10 + (s[i + 1] - '0') <= 26) ){
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}

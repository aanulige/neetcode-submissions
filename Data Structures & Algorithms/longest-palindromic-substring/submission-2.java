class Solution {
    public String longestPalindrome(String str) {
        char[] s = str.toCharArray();

        int n = s.length;
        if(n < 2) return str;

        int maxLen = 1;
        int begin = 0;

        boolean dp[][] = new boolean[n][n];

        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(s[i] == s[j] &&(j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;

                    if(j - i + 1 > maxLen){
                        begin = i;
                        maxLen = j - i + 1;
                    }
                }

                
            }
        }
        return str.substring(begin, begin + maxLen);
    }
}

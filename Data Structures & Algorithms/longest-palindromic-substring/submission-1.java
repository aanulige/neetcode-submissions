class Solution {
    public String longestPalindrome(String str) {
        char[] s = str.toCharArray();

        int n = s.length;
        if(n < 2) return str;

        int maxLen = 1;
        int begin = 0;

        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 递推开始
        // 先枚举子串长度
        for(int L = 2; L <= n; L++){
            for(int i = 0; i < n; i++){
                int j = L + i - 1;
                if(j >= n){
                    break;
                }

                if (s[i] != s[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }

        return str.substring(begin, begin + maxLen);
    }
}

class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] last = new int[256];
        int n = str.length;
        int ans = 0;
        Arrays.fill(last, -1);
        for(int l = 0, r = 0; r < n; r++){
            l = Math.max(l, last[str[r]] + 1);
            ans = Math.max(ans, r - l + 1);
            // 更新当前字符上一次出现的位置
			last[str[r]] = r;
        }

        return ans;
    }
}

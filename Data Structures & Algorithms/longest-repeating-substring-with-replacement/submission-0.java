class Solution {
    public int characterReplacement(String str, int k) {
        char[] s = str.toCharArray();
        int n = s.length;

        int[] cnt = new int[26];
        int maxf = 0, l = 0;
        for(int r = 0; r < n; r++){
            cnt[s[r] - 'A']++;
            maxf = Math.max(maxf, cnt[s[r] - 'A']);

            if(maxf + k < r - l + 1){
                cnt[s[l] - 'A']--;
                l++;
            }
        }
        return n - l;
    }
}

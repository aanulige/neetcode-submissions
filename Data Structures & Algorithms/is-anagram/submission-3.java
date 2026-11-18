class Solution {
    public int cnt[] = new int[26]; 
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            cnt[str[i] - 'a']++;
           
        }
        for(int i = 0; i < t.length(); i++){
            if(--cnt[tar[i] - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}

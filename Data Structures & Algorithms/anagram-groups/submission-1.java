class Solution {
     
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] grouped = new boolean[strs.length];
        
        for(int i = 0; i < strs.length; i++){
            if(grouped[i]){
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            grouped[i] = true;
            for(int j = i + 1; j < strs.length; j++){
                if(isAnagram(strs[i], strs[j]) && !grouped[j]){
                    list.add(strs[j]);
                    grouped[j] = true;
                }
            }
            res.add(list);
        }
        for(boolean g : grouped){
            System.out.print(g + " ");
        }

        return res;
    }


    public boolean isAnagram(String str, String tar){
        int[] cnt = new int[26];
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();

        if(s.length != t.length) {
            return false;
        }

        for(char ch : s){
            cnt[ch - 'a']++;
        }

        for(char ch : t){
            if(--cnt[ch - 'a'] < 0){
                return false;
            }
        }

        return true;
    }
}

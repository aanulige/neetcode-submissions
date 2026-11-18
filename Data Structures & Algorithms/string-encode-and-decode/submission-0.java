class Solution {
    int[] lens= new int[101];
    public int valid;

    public String encode(List<String> strs) {
        valid = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String s = strs.get(i);
            int n = s.length();
            
            lens[i] = n;
            sb.append(s);
            valid++;
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i = 0, start = 0; i < valid; i++){
            int j = start + lens[i];
            String s = str.substring(start, j);
            start = j;
            res.add(s);
        }
        return res;
    }
}

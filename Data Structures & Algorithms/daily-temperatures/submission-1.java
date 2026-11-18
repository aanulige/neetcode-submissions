class Solution {

    public int MAXN = 1001;
    public int[] stack = new int[MAXN];
    public int r;

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        r = 0;
        for(int i = 0; i < temperatures.length; i++){
            while(r > 0 && temperatures[stack[r - 1]] < temperatures[i]){
                int cur = stack[--r];   
                res[cur] = i - cur;
            }
            stack[r++] = i;
        }

        while(r > 0){
            int cur = stack[--r];  
            res[cur] = 0;
        }

        return res;
        
    }
}

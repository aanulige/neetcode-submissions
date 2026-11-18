class Solution {
    public int MAXN = 1000;
    public int[] stack = new int[MAXN];
    public int r;

    public int trap(int[] heights) {
        r = 0;
        int ans = 0;

        for(int i = 0; i < heights.length; i++){
            while(r > 0 && heights[stack[r - 1]] <= heights[i]){
                int cur = stack[--r];
                if(r == 0){
                    break;
                }
                int left = stack[r - 1];
                int h = (Math.min(heights[left], heights[i]) - heights[cur]);
                int w = i - left - 1;
                ans += h * w;
            }
            stack[r++] = i;
        }
        
        return ans;
    }
}

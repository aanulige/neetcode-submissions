class Solution {
    public int MAXN = 1001;
    public int[] stack = new int[MAXN];
    public int r;
    public int largestRectangleArea(int[] heights) {
        r = 0;
        int ans = 0, cur, left;
        for(int i = 0; i < heights.length; i++){
            while(r > 0 && heights[stack[r - 1]] >= heights[i]){
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, heights[cur] * (i - left - 1));
            }
            stack[r++] = i;
        }

        while (r > 0) {
			cur = stack[--r];
			left = r == 0 ? -1 : stack[r - 1];
			ans = Math.max(ans, heights[cur] * (heights.length - left - 1));
		}
		return ans;
    }
}

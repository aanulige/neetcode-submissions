class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                int temp = imin;
                imin = imax;
                imax = temp;
            }

            imax = Math.max(nums[i], nums[i]*imax);
            imin = Math.min(nums[i], nums[i]*imin);
            max = Math.max(imax, max);
        }        
        return max;
    }
}

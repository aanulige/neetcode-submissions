class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zero = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && zero == -1){
                zero = i;
                continue;
            }else{
                product *= nums[i];
            }
        }

        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zero == -1){
                ans[i] = product / nums[i];
            }else{
                if(i == zero){
                    ans[i] = product;
                }else{
                    ans[i] = 0;
                }
            }
        }
        return ans;
    }
}  

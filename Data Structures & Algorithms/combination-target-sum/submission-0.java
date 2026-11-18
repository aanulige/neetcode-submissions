class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, target, new ArrayList<>());
        return res;
    }

    
    public void f(int[] nums, int index, int target, List<Integer> list){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList<>(list));
        }else{
            for(int i = index; i < nums.length; i++){
                list.add(nums[i]);
                f(nums, i, target - nums[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}

class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, target, new ArrayList<>());
        return res;
    }

    public void f(int[] nums, int index, int target, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(target - nums[i] < 0){
                break;
            }

            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            f(nums, i + 1, target - nums[i], list);
            list.remove(list.size() - 1);
        }

    }
}

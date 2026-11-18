class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new ArrayList<>());
        return res;
    }


    public void f(int[] nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            f(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

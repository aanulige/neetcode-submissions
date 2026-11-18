class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void f(int[] nums, int k, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i = k; i < nums.length; i++){
            list.add(nums[i]);
            f(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}

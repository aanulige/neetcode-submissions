class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        f(nums, 0, 0, new ArrayList<>());
        return res;
    }

    public Set<Integer> set = new HashSet<>();
    public void f(int[] nums, int index, int size, List<Integer> list){
        if(size == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            f(nums, i + 1, size + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

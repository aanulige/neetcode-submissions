class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        f(nums, new ArrayList<>());
        return res;
    }

    public void f(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {  // 如果当前排列的长度等于数组长度，添加到结果中
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {  // 遍历所有数字
            if (list.contains(nums[i])) continue;  // 如果数字已在当前排列中，跳过
            list.add(nums[i]);  // 添加当前数字
            f(nums, list);  // 递归调用
            list.remove(list.size() - 1);  // 回溯，移除最后一个数字
        }
    }
}

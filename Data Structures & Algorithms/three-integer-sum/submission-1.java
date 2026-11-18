class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // 先排序数组
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
        // 如果当前数字大于 0，直接结束循环（后面的数字都更大，不可能再得到和为 0）
        if (nums[i] > 0) break;

        // 避免重复，跳过与前一个相同的元素
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        // 双指针初始化
        int l = i + 1, r = nums.length - 1;

        // 使用双指针寻找和为 -nums[i] 的两个数
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                // 找到一组解，加入答案列表
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                // 移动指针，并跳过重复的元素
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;

                // 移动指针，寻找新的组合
                l++;
                r--;
            } else if (sum < 0) {
                l++;  // 如果和小于 0，左指针右移，增加和
            } else {
                r--;  // 如果和大于 0，右指针左移，减小和
            }
        }
    }

    return ans;
    }
}

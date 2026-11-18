class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int ans = 0;
        for(Integer num : set){
            int cur_num = num;
            int range = 1;

            if(!set.contains(num - 1)){
                while(set.contains(cur_num + 1)){
                    cur_num++;
                    range++;
                }
            }
            ans = Math.max(range, ans);
        }
        return ans;
    }
}

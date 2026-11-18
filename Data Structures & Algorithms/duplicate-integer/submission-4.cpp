class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> map;

        for(int i = 0; i < n; i++){
            if(map[nums[i]] == NULL){
                map[nums[i]] = 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
};
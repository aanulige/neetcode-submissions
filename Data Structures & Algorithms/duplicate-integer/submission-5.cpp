class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> read;
        for(int i = 0; i < nums.size(); i++){
            if(read.count(nums[i])){
                return true;
            }
            read.insert(nums[i]);
        }
        return false;
    }
};
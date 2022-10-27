class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        vector<int> lis;
        lis.push_back(nums[0]);
        int size=0;
        
        for (int i=1; i<nums.size(); i++) {
            if (nums[i] > lis[size]) {
                lis.push_back(nums[i]);
                size++;
            } else {
                for (int j=0; j<=size; j++) {
                    if (lis[j] >= nums[i]) {
                        lis[j] = nums[i];
                        break;
                    }
                }
            }
            if (size>=2) return true;
        }
        
        return false;
    }
};
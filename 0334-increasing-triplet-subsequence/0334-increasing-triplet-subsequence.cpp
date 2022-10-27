class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int first = INT_MAX-1, second = INT_MAX;
        
        for (int num : nums) {
            if (num > second) {
                return true;
            } else if (num <= first) {
                first = num;
            } else {
                second = num;
            }
        }
        
        return false;
    }
};
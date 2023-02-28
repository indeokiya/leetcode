class Solution {
    
private:
    vector<int> noElem = {-1, -1};
    
    int left(vector<int>& nums, int target) {
        int l=0, r=nums.size();
        
        while (l < r) {
            int mid = (l+r) >> 1;
            if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
    
    int right(vector<int>& nums, int target) {
        int l=0, r=nums.size();
        
        while (l < r) {
            int mid = (l+r) >> 1;
            if (nums[mid] <= target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
    
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) return noElem;
        
        int l = left(nums, target);
        if (l == nums.size() || nums[l] != target) l = -1;
        int r = l == -1 ? -1 : right(nums, target)-1;
        
        return vector<int>{l, r};
    }
};
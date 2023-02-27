class Solution {
    
private:
    vector<int> noElem = {-1, -1};
    
    int left(vector<int>& nums, int target) {
        int l=0, r=nums.size();
        if (nums[l] > target) return -1;
        if (nums[l] == target) return l;
        
        while (true) {
            int mid = (l+r) >> 1;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
            
            if (l+1 >= r) {
                if (r == nums.size() || nums[r] != target) return -1;
                return r;
            }
        }
    }
    
    int right(vector<int>& nums, int target) {
        int l=0, r=nums.size();
        while (true) {
            int mid = (l+r) >> 1;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
            
            if (l+1 >= r) {
                if (nums[l] == target) return l;
                return -1;
            }
        }
    }
    
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) return noElem;
        
        int l = left(nums, target);
        int r = l == -1 ? -1 : right(nums, target);
        
        return vector<int>{l, r};
    }
};
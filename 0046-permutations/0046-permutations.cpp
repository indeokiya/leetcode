class Solution {
private:
    vector<vector<int>> ans;
    int fullMask;
    int n;
    
    void permutation(int mask, vector<int>& vec, vector<int>& nums) {
        if ((mask ^ fullMask) == 0) {
            ans.push_back(vec);
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (mask & (1<<i)) continue;
            vector<int> newVec(vec);
            newVec.push_back(nums[i]);
            permutation(mask ^ (1<<i), newVec, nums);
        }
    }
    
public:
    vector<vector<int>> permute(vector<int>& nums) {
        n = nums.size();
        fullMask = (1 << n) - 1;
        vector<int> v;
        permutation(0, v, nums);
        
        return ans;
    }
};
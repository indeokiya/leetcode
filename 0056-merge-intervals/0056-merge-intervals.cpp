class Solution {
private:
    vector<vector<int>> ans;
    static bool cmp(vector<int> const &l, vector<int> const &r) {
        return l[0] == r[0] ? l[1] < r[1] : l[0] < r[0];
    } 
    
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        int l = intervals[0][0], r = intervals[0][1];
        
        for (int i=1; i<intervals.size(); i++) {
            int nL = intervals[i][0];
            int nR = intervals[i][1];
            
            if (nL > r) {
                vector<int> vec{l, r};
                ans.push_back(vec);
                l = nL; r = nR;
                continue;
            }
            
            r = max(r, nR);
        }
        
        
        vector<int> vec{l, r};
        ans.push_back(vec);
        
        return ans;
    }
};

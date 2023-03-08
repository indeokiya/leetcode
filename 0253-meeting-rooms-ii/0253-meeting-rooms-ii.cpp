class Solution {
private:
    int ans;
    priority_queue<int, vector<int>, greater<int>> pq; 
    
public:   
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        
        
        for (const auto& interval : intervals) { 
            
            while (!pq.empty() && pq.top() <= interval[0]) {
                pq.pop();
            }
            pq.push(interval[1]);
            ans = max(ans, (int)pq.size());
        }
        
        
        return ans;
    }
};
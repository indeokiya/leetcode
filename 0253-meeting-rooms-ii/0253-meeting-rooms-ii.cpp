class Solution {
private:
    int ans;
    priority_queue<int, vector<int>, greater<int>> pq; 
    
public:   
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        
        
        for (auto it = intervals.begin(); it != intervals.end(); it++) {
            int l = (*it)[0], r = (*it)[1];
            if (pq.empty() || pq.top() > l) {
                pq.push(r);
                ans = max(ans, (int)pq.size() );
                continue;
            }
            
            while (!pq.empty() && pq.top() <= l) {
                pq.pop();
            }
            pq.push(r);
            ans = max(ans, (int)pq.size());
        }
        
        
        return ans;
    }
};
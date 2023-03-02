class Solution {
private:
    int chars[128];

public:
    string minWindow(string s, string t) {
        
        for (int i=0; i<t.length(); i++) {
            chars[t[i]]++;
        }
        
        int l = 0, r = 0;
        int remaining = t.length();
        int minLen = numeric_limits<int>::max();
        int minStart = 0;
        
        while (r < s.length()) {
            if (chars[s[r++]]-- > 0) remaining--;
            while (remaining == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }
                    
                if (chars[s[l++]]++ >= 0) remaining++;
            }
        }
        
        
        return minLen < numeric_limits<int>::max() ? s.substr(minStart, minLen) : "";
    }
};
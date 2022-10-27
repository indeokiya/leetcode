class Solution {

public:
    string longestPalindrome(string s) {
        int len = s.length();
        string ans;
        int max = -1;
        int start=0;
        for (int i=0; i<len; i++) {
            int tmp1 = findLength(s, i-1, i+1);
            int tmp2 = findLength(s, i, i+1);
            int tmp = std::max(tmp1, tmp2);
            if (tmp>max) {
                max = tmp;
                start = i-(tmp-1)/2;
            }
        }
        
        return s.substr(start, max);
    }
    
private:
    int findLength(string &s, int left, int right) {
        int len = s.length();
        
        while (left>=0 && right<len && s[left]==s[right]) {
            left--;
            right++;
        }
        
        return right-left-1;
    }
};
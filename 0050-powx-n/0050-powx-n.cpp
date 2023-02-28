class Solution {
public:
    double myPow(double x, int n) {
        if (n < 0) return (1/x) * myPow(1/x, ~n);
        
        double ans = 1;
        double curr = x;
        while (n > 0) {
            if (n & 1) {
                ans *= curr;
            }
            n >>= 1;
            curr *= curr;
        }
        return ans;
    }
};
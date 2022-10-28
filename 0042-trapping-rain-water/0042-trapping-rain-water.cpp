class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> stack;
        int ans = 0;
        int max = 0;
        
        for (int i=0; i<height.size(); i++) {
            if (height[i] >= max) {
                ans += stack.size() * max;
                while (!stack.empty()) {
                    ans -= stack.top(); stack.pop(); 
                }
                max = height[i];
            } 
            stack.push(height[i]);
        }
        
        max=0;
        while (!stack.empty()) {
            if (stack.top() > max) {
                max = stack.top(); stack.pop();
            } else {
                ans += max-stack.top(); stack.pop();
            }
        }
        return ans;
    }
};
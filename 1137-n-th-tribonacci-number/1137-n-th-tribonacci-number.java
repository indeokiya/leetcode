class Solution {
    public int tribonacci(int n) {
        if (n==0) return 0;
        if (n<=2) return 1;
        
        int num1 = 0, num2 = 1, num3 = 1;
        int curr = 2;
        
        for (int i=3; i<=n; i++) {
            curr = num1+num2+num3;
            num1 = num2;
            num2 = num3;
            num3 = curr;
        }
        
        return curr;
    }
}
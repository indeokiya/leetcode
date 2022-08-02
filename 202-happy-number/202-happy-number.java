class Solution {
    
    public int divNsqr(int n) {
        int tmp = 0;
        while (n>0) {
            tmp += Math.pow(n%10, 2);
            n = n/10;
        }
        return tmp;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> mySet = new HashSet<>();
        while (true) {
            if (n == 1) return true;
            if (mySet.contains(n)) return false;
            mySet.add(n);
            n = divNsqr(n);
        }
    }
}
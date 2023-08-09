class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[1001];
        for (int num : citations) {
            counts[num]++;
        }
        int sum = 0;
    
        for (int i=1000; i>=1; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
class Solution {
    private int[] arr;
    private int idx2=0, idx3=0, idx5=0;
    
    public void dp(int i) {
        int multiplied2 = arr[idx2] * 2;
        int multiplied3 = arr[idx3] * 3;
        int multiplied5 = arr[idx5] * 5;
        
        arr[i] = Math.min(multiplied2, Math.min(multiplied3, multiplied5));
        
        if (arr[i] == multiplied2) idx2++;
        if (arr[i] == multiplied3) idx3++;
        if (arr[i] == multiplied5) idx5++;
    }
    
    public int nthUglyNumber(int n) {
        arr = new int[n];
        arr[0] = 1;
        for (int i=1; i<n; i++) {
            dp(i);
        }

        return arr[n-1];
    }
}

// 2 4 8 16 32 64 128
// 3 9 27 81 243 729
// 5 25 125 625 3125
// (0, 0, 0)  (10, 10, 10)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        // if (arr.length % 2 == 0) {
        //     return sumOddLengthSubarrays(Arrays.copyOfRange(arr, 0, len)) + sumOddLengthSubarrays(Arrays.copyOfRange(arr, 1, len+1));
        // }
        
        int ans = 0;
        int tmp;
        for (int i=0; i<len; i++) {
            tmp = arr[i];
            for (int j=1; j<len+1; j+=2) {
                ans += tmp*Math.min(Math.min(j, len+1-j), Math.min(i+1, len-i) );
            }
        }
        
        return ans;
    }
}


// 1 1 1 1 1  1 1 1 1 1  1  1
// 1 2 3 3 3  3 3 3 3 2  1  3
// 1 2 3 4 5  5 5 4 3 2  1  5
// 1 2 3 4 5  5 5 4 3 2  1  7
// 1 2 3 3 3  3 3 3 3 2  1  9
// 1 1 1 1 1  1 1 1 1 1  1  11
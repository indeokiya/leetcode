class Solution {
    public int binarySearch(int[] res, int num, int size) {
        int left = 0;
        int right = size;

        while (left<right) {
            int mid = (left+right) >> 1;
            if (res[mid] < num) {
                left = mid+1;
            } else if (res[mid] > num ) {
                right = mid;
            } else {
                return mid;
            }
            mid = (left+right) >> 1;
        }
        
        return right;
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];

		res[0] = nums[0];
		int size = 0;
		for (int i=1; i<nums.length; i++) {
			int curr = nums[i];
			if (curr > res[size]) {
				res[++size] = curr;
			} else {
				int idx = binarySearch(res, curr, size);
				res[idx] = curr;
			}
		}
        
        return size+1;
    }
}
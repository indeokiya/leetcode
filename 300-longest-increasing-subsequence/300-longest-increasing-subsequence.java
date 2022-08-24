class Solution {
    public int doBinarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size()-1;
        int mid = (left+right)/2;
        while (left<right) {
            if (list.get(mid) < num) {
                left = mid+1;
            } else if (list.get(mid) > num ) {
                right = mid;
            } else {
                return mid;
            }
            mid = (left+right)/2;
        }
        
        return right;
    }
    
    public int lengthOfLIS(int[] nums) {
        List<Integer> myList = new LinkedList<>();
        myList.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > myList.get(myList.size()-1)) {
                myList.add(nums[i]);
            } else {
                int idx = doBinarySearch(myList, nums[i]);
                myList.set(idx, nums[i]);
            }
        }
        
        return myList.size();
    }
}
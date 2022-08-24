class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> myList = new LinkedList<>();
        myList.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > myList.get(myList.size()-1)) {
                myList.add(nums[i]);
            } else {
                for (int j=0; j<myList.size(); j++) {
                    if (myList.get(j) >= nums[i]) {
                        myList.set(j, nums[i]);
                        break;
                    }
                }
            }
        }
        
        return myList.size();
    }
}
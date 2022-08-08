class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> myStack = new Stack<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        
        int[] ans = new int[nums1.length];
        
        for (int i=0; i<nums2.length; i++) {
            while (!myStack.isEmpty() && myStack.peek() < nums2[i]) {
                myMap.put(myStack.pop(), nums2[i]);
            }
            myStack.push(nums2[i]);
        }
        
        while(!myStack.isEmpty()) {
            myMap.put(myStack.pop(), -1);
        }
        
        for (int i=0; i<nums1.length; i++) {
            ans[i] = myMap.get(nums1[i]);
        }
        
        return ans;
    }
}
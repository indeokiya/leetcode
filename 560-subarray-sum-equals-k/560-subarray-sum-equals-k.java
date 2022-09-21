class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1]; 
        }
        
        int ans = 0;
        
        HashMap<Integer, Integer> myMap = new HashMap<>();
        
        for (int i=1; i<=nums.length; i++) {
            myMap.put(preSum[i-1], myMap.getOrDefault(preSum[i-1], 0)+1);
            ans += myMap.getOrDefault(preSum[i]-k, 0);
        }
        
        return ans;
    }
}
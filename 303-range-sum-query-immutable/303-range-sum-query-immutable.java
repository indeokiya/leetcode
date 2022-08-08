class NumArray {
    List<Integer> arr = new LinkedList<>();
    public NumArray(int[] nums) {
        int len = nums.length;
        
        for (int i=0; i<len; i++) {
            int tmp_sum = nums[i];
            for (int j=i+1; j<len; j++) {
                tmp_sum += nums[j];
            }
            arr.add(tmp_sum);
        }
        arr.add(0);
    }
    
    public int sumRange(int left, int right) {
        return arr.get(left) - arr.get(right+1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
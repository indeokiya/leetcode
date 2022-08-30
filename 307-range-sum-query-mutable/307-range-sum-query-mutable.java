class NumArray {
    private int[] nums;
    private int[] bit;

    public NumArray(int[] nums) {
        this.nums = nums;
        bit = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++) {
            init(i, nums[i-1]);
        }
    }
    
    public void init(int i, int val) {
        while (i<=nums.length) {
            bit[i] += val;
            i += (i&-i);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val; 
        init(++index, diff);
    }
    
    public int sum(int i) {
        int ret=0;
        ++i;
        while(i>0) {
            ret += bit[i];
            i -= (i&-i);
        }
        return ret;
    }
    
    public int sumRange(int left, int right) {
        return sum(right) - sum(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
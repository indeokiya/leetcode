class MovingAverage {

    int size;
    int cnt;
    int[] nums;

    public MovingAverage(int size) {
        this.size = size;
        this.cnt = 0;
        this.nums = new int[size];
    }
    
    public double next(int val) {
        nums[cnt%size] = val;
        cnt++;
        return cnt < size ? avg()*size/cnt : avg();
    }

    private double avg() {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // return Arrays.stream(nums).average().getAsDouble();
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
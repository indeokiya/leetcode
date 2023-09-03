class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int prev = lower - 1;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] - 1 == prev) {
                prev = nums[i];
                continue;
            }
            ans.add(addList(prev+1, nums[i]-1));
            prev = nums[i];
        }

        if (prev < upper) {
            ans.add(addList(prev+1, upper));
        }

        return ans;
    }

    private List<Integer> addList(int l, int r) {
        List<Integer> list = new ArrayList<>();
        list.add(l);
        list.add(r);
        return list;
    }
}
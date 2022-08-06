class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        ans.add(init);
        for (int i=1; i<numRows; i++) {
            List<Integer> next = new ArrayList<>();
            int tmp = 1;
            next.add(1);
            for (int j=1; j<ans.get(i-1).size(); j++) {
                tmp = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                next.add(tmp);
            }
            next.add(1);
            ans.add(next);
        }
        return ans;
    }
}
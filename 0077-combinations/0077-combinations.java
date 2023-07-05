class Solution {
    private List<List<Integer>> answer;
    
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        backTracking(new ArrayList<Integer>(), n, 1, k);
        
        return answer;
    }
    
    private void backTracking(List<Integer> list, int n, int idx, int k) {
        if (list.size() == k) {
            List<Integer> tmp = new ArrayList<>(list);
            answer.add(tmp);
            return;
        }
        if (list.size() + n-idx+1 < k) {
            return;
        }
        
        list.add(idx);
        backTracking(list, n, idx+1, k);
        list.remove(list.size()-1);
        backTracking(list, n, idx+1, k);
    }
}
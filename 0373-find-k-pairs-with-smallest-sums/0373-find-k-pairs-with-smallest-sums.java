class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        pq.add(new int[]{nums1[0]+nums2[0], 0, 0});

        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int p1 = top[1];
            int p2 = top[2];
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p1]);
            list.add(nums2[p2]);
            ans.add(list);

            if (p1+1 < nums1.length) {
                Pair<Integer, Integer> tmp1 = new Pair<>(p1+1, p2);
                if (!visited.contains(tmp1)) {
                    visited.add(tmp1);
                    pq.add(new int[]{nums1[p1+1] + nums2[p2], p1+1, p2});
                }
            }
            if (p2+1 < nums2.length) {
                Pair<Integer, Integer> tmp2 = new Pair<>(p1, p2+1);
                if (!visited.contains(tmp2)) {
                    visited.add(tmp2);
                    pq.add(new int[]{nums1[p1] + nums2[p2+1], p1, p2+1});
                }
            }
        }
        
        return ans;
    }
}
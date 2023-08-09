class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : citations) {
            pq.add(num);
        }
        for (int i=1; i<=citations.length; i++) {
            if (pq.poll() < i) {
                return i-1;
            }
        }
        return citations.length;
    }
}
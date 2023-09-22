class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int N = profits.length;
        for (int i=0; i<N; i++) {
            pq.offer(new Pair(profits[i], capital[i]));
        }

        PriorityQueue<Integer> availableProfit = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<k; i++) {
            while (!pq.isEmpty() && pq.peek().capital <= w) {
                availableProfit.offer(pq.peek().profit);
                pq.poll();
            }

            if (availableProfit.isEmpty()) break;
            w += availableProfit.peek();
            availableProfit.poll();
        }

        return w;
    }

    static class Pair implements Comparable<Pair> {
        int profit;
        int capital;

        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo (Pair p) {
            return this.capital - p.capital;
        }
    }
}
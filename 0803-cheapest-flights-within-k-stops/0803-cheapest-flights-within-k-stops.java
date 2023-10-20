class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] flight: flights) {
            edges.computeIfAbsent(flight[0], v -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //dist_from_origin, node, #_of_stops_from_origin
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            int steps = pq.peek()[2];
            pq.poll();

            if (steps > k + 1 || steps >= stops[node])
                continue;
            if (node == dst)
                return distance;

            stops[node] = steps;

            if (!edges.containsKey(node))
                continue;
            for (int[] edge : edges.get(node)) {
                pq.offer(new int[]{distance + edge[1], edge[0], steps+1});
            }
        }

        return -1;
    }
}
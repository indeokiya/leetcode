class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>(); 
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (arr[curr] == 0) {
                return true;
            }

            int l = curr - arr[curr];
            int r = curr + arr[curr];
            if (l >= 0 && l < N && !visited[l]) {
                visited[l] = true;
                q.add(l);
            }
            if (r >= 0 && r < N && !visited[r]) {
                visited[r] = true;
                q.add(r);
            }
        }

        return false;
    }
}
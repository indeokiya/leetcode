class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.computeIfAbsent(id, k -> new LinkedList<>()).add(score);
        }

        int size = map.size();
        int[][] answer = new int[size][];
        for (int id : map.keySet()) {
            List<Integer> scores = map.get(id);
            double sum = scores.stream()
                .sorted(Collections.reverseOrder())
                .limit(5)
                .mapToDouble(i -> i)
                .sum();
            answer[--size] = new int[]{id, (int)(sum/5)};
        }
        Arrays.sort(answer, (o1, o2) -> o1[0] - o2[0]);
        return answer;
    }
}
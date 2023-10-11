class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);

        Arrays.sort(flowers, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, Integer> dic = new HashMap<>();

        int i = 0;
        int iter = 0;
        for (int person : sortedPeople) {
            while (i < flowers.length && flowers[i][0] <= person) {
                heap.offer(flowers[i][1]);
                i++;
            }

            while (!heap.isEmpty() && heap.peek() < person) {
                heap.poll();
            }

            dic.put(person, heap.size());
        }

        int[] answer = new int[people.length];
        for (int j=0; j<people.length; j++) {
            answer[j] = dic.get(people[j]);
        }

        return answer;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length-k+1];
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int i=0, answerIdx=0; i<nums.length; i++) {
            while (!queue.isEmpty() && queue.peekLast().num < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(new Pair(i, nums[i]));
            while (!queue.isEmpty() && queue.peekFirst().index < i-k+1) {
                queue.pollFirst();
            }

            if (i < k-1) {
                continue;
            }

            answer[answerIdx++] = queue.peekFirst().num;
        }

        return answer;
    }

    static class Pair {
        protected int index;
        protected int num;
        
        Pair(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
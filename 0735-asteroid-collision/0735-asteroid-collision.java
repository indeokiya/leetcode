class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                deq.offerLast(ast);
                continue;
            }
            collide(deq, ast);
        }

        int[] ans = new int[deq.size()];
        for (int i=0; !deq.isEmpty(); i++) {
            ans[i] = deq.pollFirst();
        }
        return ans;
    }

    private void collide(ArrayDeque<Integer> deq, int ast) {
        while (!deq.isEmpty() && deq.peekLast() > 0 && deq.peekLast() < -ast) {
            deq.pollLast();
        }

        if (deq.isEmpty() || deq.peekLast() < 0) {
            deq.offerLast(ast);
        } else if (deq.peekLast() == -ast) {
            deq.pollLast();
        } else if (deq.peekLast() < -ast){
            deq.pollLast();
            deq.offerLast(ast);
        }
    }
}
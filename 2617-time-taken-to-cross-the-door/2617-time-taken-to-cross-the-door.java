class Solution {
    private enum Prev {
        NONE, ENTER, EXIT
    }

    private int[] ans;
    private Prev prev;

    public int[] timeTaken(int[] arrival, int[] state) {
        int N = state.length;
        ans = new int[N];
        prev = Prev.NONE;

        Queue<Person> entering = new LinkedList<>();
        Queue<Person> exiting = new LinkedList<>();

        for(int t=0, p=0; p!=N || !entering.isEmpty() || !exiting.isEmpty(); t++) {
            while (p < N && arrival[p] <= t) {
                if (state[p] == 0) {
                    entering.offer(new Person(p, 0));
                } else {
                    exiting.offer(new Person(p, 1));
                }
                p++;
            }
            
            int nWait = entering.size() + exiting.size();
            if (nWait == 0) {
                prev = prev.NONE;
                continue;
            }

            if (nWait == 1) {
                if (!entering.isEmpty()) {
                    pollFrom(entering, t);
                } else {
                    pollFrom(exiting, t);                       
                }
                continue;
            }

            if (prev == Prev.NONE) {
                if (!exiting.isEmpty()) {
                    pollFrom(exiting, t);
                } else {
                    pollFrom(entering, t);
                }
            } else if (prev == Prev.ENTER) {
                if (!entering.isEmpty()) {
                    pollFrom(entering, t);
                } else {
                    pollFrom(exiting, t);  
                }
            } else {
                if (!exiting.isEmpty()) {
                    pollFrom(exiting, t);  
                } else {
                    pollFrom(entering, t);
                }
            }

        }

        return ans;
    }

    private void pollFrom(Queue<Person> q, int t) {
        Person person = q.poll();
        prev = person.exit == 1 ? Prev.EXIT : Prev.ENTER;
        ans[person.idx] = t;
    }

    static class Person {
        int idx;
        int exit;

        public Person(int idx, int exit) {
            this.idx = idx;
            this.exit = exit;
        }
    }
}
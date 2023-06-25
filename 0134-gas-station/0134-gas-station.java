class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int[] diff = new int[N];
        int sum = 0;
        for (int i=0; i<N; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        
        if (sum < 0) {
            return -1;
        }
        
        sum = 0;
        int start = 0;
        int iter = 0;
        for (int end=0; iter < N; end++) {
            sum += diff[end];
            ++iter;
            while (sum < 0) {
                start = (start-1+N) % N;
                sum += diff[start];
                ++iter;
            }
        }
        
        return start;
    }
}

/*
make diff array, sum
if sum < 0
    return -1

below this line, answer is guaranteed

sum = 0
start = 0
from end 0 to start-1
    sum += diff[end]
    while sum < 0
        start = (start-1 + N) % N
        sum += diff[start]
        
return start
*/
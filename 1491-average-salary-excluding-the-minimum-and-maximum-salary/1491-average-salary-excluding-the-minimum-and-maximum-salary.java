class Solution {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for(int sal: salary) {
            if (sal < min) {
                min = sal;
            } else if (sal > max) {
                max = sal;
            }
            sum += sal;
        }
        return (double)(sum-max-min)/(salary.length - 2);
    }
}
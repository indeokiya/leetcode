class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);

        int day = 0;
        for (int i=0; i<jobs.length; i++) {
            day = Math.max(day, (int)Math.ceil((double)jobs[i]/workers[i]));
        }
        return day;
    }
}
class Solution {

    Map<Integer, Integer> dp;
    TreeMap<Integer, Integer> startTimeMap;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int[][] jobs = new int[startTime.length][3];
        startTimeMap = new TreeMap<>();

        for (int i=0; i<startTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
            startTimeMap.put(startTime[i], i);
        }

        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));

        dp = new HashMap<>();

        return dfs(0, jobs);
    }

    int dfs(int curr, int[][] jobs) {
        if (curr == jobs.length) {
            return 0;
        }

        if (dp.containsKey(curr))
            return dp.get(curr);

        Map.Entry<Integer, Integer> e = startTimeMap.higherEntry(jobs[curr][1]);

        int next = findNext(curr, jobs);
        int including = jobs[curr][2] + (next == -1 ? 0 : dfs(next, jobs));
        int excluding = dfs(curr+1, jobs);

        dp.put(curr, Math.max(including, excluding));
        return dp.get(curr);
    }

    int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;   
            }
        }
        return -1;
    }


}
class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> arrList = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] curr = new int[]{intervals[0][0], intervals[0][1]};

        for (int i=0; i<intervals.length; i++) {
            System.out.println("curr: " + Arrays.toString(curr));
            // if the interval overlaps, merge it
            if (intervals[i][0] <= curr[1]) 
                curr[1] = (intervals[i][1] > curr[1]) ? intervals[i][1] : curr[1];
            // do not overlap
            else {
                // add curr to the arrList
                arrList.add(new int[]{curr[0], curr[1]});
                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
            }
        }

        arrList.add(new int[]{curr[0], curr[1]});

        int[][] result = arrList.toArray(new int[0][]);
        
        return result;
    }
}
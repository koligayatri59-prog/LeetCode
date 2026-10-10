class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if there's only one interval, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Initialize with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Step 2: Iterate through the intervals and merge overlaps
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap detected: update the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Step 3: Convert the List back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
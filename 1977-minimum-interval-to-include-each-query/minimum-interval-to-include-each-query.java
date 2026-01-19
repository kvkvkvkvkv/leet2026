class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]) {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });    

        List<int[]> val = new ArrayList();
        int i=0;
        for(int ele:queries) {
            val.add(new int[]{i++,ele});
        }
        int[] ans = new int[queries.length];
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Collections.sort(val, (a,b) -> Integer.compare(a[1],b[1]));
        int idx = 0;
        for(int[] ele: val) {
            while(idx<intervals.length && intervals[idx][0]<=ele[1]) {
                q.add(new int[]{intervals[idx][1]-intervals[idx][0]+1, intervals[idx][1]});
                idx++;
            }

            while(!q.isEmpty() && ele[1]>q.peek()[1]) {
                q.poll();
            }

            if (q.isEmpty()) {
                ans[ele[0]] = -1;
            } else {
                ans[ele[0]] = q.peek()[0]; 
            }
        }
        return ans;
    }
}
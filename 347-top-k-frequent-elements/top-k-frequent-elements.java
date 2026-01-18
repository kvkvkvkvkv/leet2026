class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<Integer> q = new PriorityQueue((a,b) -> 
        Integer.compare(map.get(a), map.get(b))
        );
        for(int ele:nums) {
            map.put(ele, map.getOrDefault(ele,0)+1);
        }

        for(int key:map.keySet()) {
            q.add(key);
            if(q.size()>k) {
                q.poll();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(!q.isEmpty()) {
            ans[i++] =  q.poll();
        }
        return ans;
    }
}
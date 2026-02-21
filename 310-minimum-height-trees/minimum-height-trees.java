
import java.lang.reflect.Array;class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(edges.length == 0) {
            return Arrays.asList(0);
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();

        for(int[] ele:edges) {
            map.computeIfAbsent(ele[0], k -> new HashSet<>()).add(ele[1]);
            map.computeIfAbsent(ele[1], k -> new HashSet<>()).add(ele[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int key:map.keySet()) {
            if(map.get(key).size()==1) {
                q.add(key);
            }
        }

        int tot = n;
        while(tot>2) {
            
            int size = q.size();

            while(size>0) {
                int top = q.poll();
                tot--;
                for(int next:map.get(top)) {
                    map.get(next).remove(top);
                    if(map.get(next).size() == 1) {
                        q.add(next);
                    }
                }    
                size--;
            }
        }

        return new ArrayList<>(q);
    }
}
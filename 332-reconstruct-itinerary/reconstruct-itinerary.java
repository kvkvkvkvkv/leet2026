class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> map = new HashMap();

        for(List<String> tix:tickets) {
            String key = tix.get(0);
            String val = tix.get(1);
            map.computeIfAbsent(key, k -> new LinkedList<>()).add(val);
        }
        
        LinkedList <String> ans = new LinkedList<>();
        dfs(map, "JFK", ans);
        return ans;
    }

    void dfs(Map<String, LinkedList<String>> map, String start, LinkedList<String> ans) {
        if(map.containsKey(start)) {
            LinkedList<String> neigh =  map.get(start);
            Collections.sort(neigh);
            while (!neigh.isEmpty()) {
                String top = neigh.removeFirst();
                dfs(map, top, ans);
            }
        }
        ans.addFirst(start);
    }
}
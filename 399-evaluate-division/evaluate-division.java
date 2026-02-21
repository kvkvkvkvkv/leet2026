class Solution {
    Map<String,Map<String,Double>> map;
    Map<Pair<String,String>,Double> memo;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        memo = new HashMap<>();
        map = new HashMap<>();
        int index = 0;
        for(List<String> ele:equations) {
            String k1 = ele.get(0);
            String v1 = ele.get(1);
            map.computeIfAbsent(k1, k -> new HashMap<>()).put(v1, values[index]);
            map.computeIfAbsent(v1, k -> new HashMap<>()).put(k1, (double)1/values[index++]);
        }

        double[] ans = new double[queries.size()];
        int i=0;
        for(List<String> q:queries) {
            String k1 = q.get(0);
            String v1 = q.get(1);

            if(!map.containsKey(k1) || !map.containsKey(v1)) {
                ans[i++] = -1;
                continue;
            }
            double val = dfs(k1,v1, new HashSet());
            ans[i++] = val;
        }
        return ans;
    }

    double dfs(String k, String v, Set<String> seen) {
        if(k.equals(v)) {
            return 1;
        }

        seen.add(k);
        for(String next:map.get(k).keySet()) {
            if(seen.contains(next)) {
                continue;
            }
            double val = dfs(next, v,seen);
            if(val>0) {
                val*=(map.get(k).get(next));
                seen.remove(k); 
                return val;
            }
        
        }
        seen.remove(k);
        //memo.put(p,-1d);
        return -1;
    }
}
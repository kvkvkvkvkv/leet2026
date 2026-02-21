class Solution {
    Map<String, Map<String, Double>> g = new HashMap<>();
    Map<String, Double> memo = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double w = values[i];

            g.computeIfAbsent(a, k -> new HashMap<>()).put(b, w);
            g.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / w);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);
            ans[i] = dfs(s, t, new HashSet<>());
        }
        return ans;
    }

    double dfs(String u, String v, Set<String> seen) {
        if (!g.containsKey(u) || !g.containsKey(v)) return -1.0;
        if (u.equals(v)) return 1.0;

        String key = u + "#" + v;
        if (memo.containsKey(key)) return memo.get(key);

        // direct edge shortcut helps a lot on star graphs
        if (g.get(u).containsKey(v)) {
            double direct = g.get(u).get(v);
            memo.put(key, direct);
            return direct;
        }

        if (seen.contains(u)) return -1.0;
        seen.add(u);

        for (Map.Entry<String, Double> e : g.get(u).entrySet()) {
            String nxt = e.getKey();
            double w = e.getValue();

            double sub = dfs(nxt, v, seen);
            if (sub != -1.0) {
                double res = w * sub;
                memo.put(key, res);
                seen.remove(u);
                return res;
            }
        }

        seen.remove(u);
        memo.put(key, -1.0);
        return -1.0;
    }
}
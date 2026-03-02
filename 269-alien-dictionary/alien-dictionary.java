class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    boolean[] seen = new boolean[26];
    boolean[] stack = new boolean[26];
    public String alienOrder(String[] words) {
        
        buildMap(words);

        for(int i=1;i<words.length;i++) {
            int len1 = words[i-1].length();
            int len2 = words[i].length();
            int index = 0;
            int min = Math.min(len1, len2);
            
            for(index=0;index<min;index++) {
                char next = words[i].charAt(index);
                char prev = words[i-1].charAt(index); 
                if(next != prev) {
                    map.computeIfAbsent(next, k -> new ArrayList<>()).add(prev);
                    break;
                }
            }

            if(index==min) {
                if(len2<len1) {
                    return "";
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(char key:map.keySet()) {
            if(!seen[key-'a'] && dfs(key, sb)) {
                return "";
            }
        }
        return sb.toString();
    }

    boolean dfs(char node, StringBuffer sb) {

        if(stack[node-'a']) {
            return true;
        }

        if(seen[node-'a']) {
            return false;
        }

        seen[node-'a'] = true;
        stack[node-'a'] = true;

        for(char next:map.get(node)) {
            if(dfs(next, sb)) {
                return true;
            }
        }
        sb.append(node);
        stack[node-'a'] = false;
        return false;
    }

    void buildMap(String[] words) {
        for(int i=0;i<words.length;i++) {
            int len2 = words[i].length();
            for(int index=0;index<len2;index++) {
                char next = words[i].charAt(index);
                map.computeIfAbsent(next, k -> new ArrayList<>());
            }
        }
    }
}
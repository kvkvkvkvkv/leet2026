class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> val =  new HashSet<>(wordList);
        Map<String, Set<String>> map = new HashMap();
        if (!val.contains(endWord)) {
            return 0;
        }

        for(String ele:val) {
            char[] cur = ele.toCharArray();
            for(int i=0;i<cur.length;i++) {
                char temp = cur[i];
                cur[i] = '*';
                map.computeIfAbsent(String.valueOf(cur), k -> new HashSet<>()).add(ele);
                cur[i] = temp;
            }
        }

        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                String top = q.poll();
                if(top.equals(endWord)) {
                    return count+1;
                }
                char[] cur = top.toCharArray();
                for(int i=0;i<cur.length;i++) {
                    char temp = cur[i];
                    cur[i] = '*';
                    String key = String.valueOf(cur);

                    for(String next:map.getOrDefault(key, new HashSet<>())) {
                        if(!seen.contains(next)) {
                            q.add(next);
                            seen.add(next);
                        }
                    }
                    cur[i] = temp;
                }
                size--;
            }
            count++;
        }
        return 0;
    }
}
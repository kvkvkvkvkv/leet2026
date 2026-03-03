class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char ele:s.toCharArray()) {
            map1.put(ele, map1.getOrDefault(ele, 0)+1);
        }

        for(char ele:t.toCharArray()) {
            map2.put(ele, map2.getOrDefault(ele, 0)+1);
        }

        return map1.equals(map2);
        
    }
}
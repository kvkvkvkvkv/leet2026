class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();

        for(char ele:s.toCharArray()) {
            map1.put(ele, map1.getOrDefault(ele, 0)+1);
        }

        for(char ele:t.toCharArray()) {
            if(!map1.containsKey(ele)) {
                return false;
            }
            map1.put(ele, map1.get(ele)-1);
        }

        for(char key:map1.keySet()) {
            if(!map1.get(key).equals(0)) {
                return false;
            }
        }

        return true;
        
    }
}
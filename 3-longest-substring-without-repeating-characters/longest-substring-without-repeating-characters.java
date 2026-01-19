class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap();
        for(int r=0;r<s.length();r++) {
            char cur = s.charAt(r);
            if(map.containsKey(cur) && map.get(cur)>=l) {
                l = map.get(cur)+1;
            }
            map.put(cur, r);
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
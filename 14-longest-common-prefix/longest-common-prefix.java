class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev = strs[0];
        for(int i=1;i<strs.length;i++) {
            int min = Math.min(strs[i].length(), prev.length());
            int j=0;
            while(j<min) {
                char one = prev.charAt(j);
                char two = strs[i].charAt(j);
                if(one != two) {
                    break;
                }
                j++;
            }

            if(j==0) {
                return "";
            }
            prev = prev.substring(0,j);
        }
        return prev;
    }
}
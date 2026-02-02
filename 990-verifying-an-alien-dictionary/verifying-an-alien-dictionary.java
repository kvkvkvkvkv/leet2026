class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ele:order.toCharArray()) {
            map.putIfAbsent(ele, index++);
        }

        for(int value=1;value<words.length;value++) {
            int idx = check(words[value-1],words[value]);
            if(idx == -1) {
                return false;
            }

            if(idx == words[value-1].length()) {
                continue;
            }
            char one = words[value-1].charAt(idx);
            char two = words[value].charAt(idx);
            
            if(map.get(one)>map.get(two)) {
                return false;
            }
        }
        return true;
    }

    int check(String first, String second) {
        int i1=0, i2=0;
        while(i1<first.length() && i2<second.length()) {
            if(first.charAt(i1)!=second.charAt(i2)) {
                return i1;
            }
            i1++;
            i2++;
        }
        return i1==first.length()?i1:-1;
    }
}
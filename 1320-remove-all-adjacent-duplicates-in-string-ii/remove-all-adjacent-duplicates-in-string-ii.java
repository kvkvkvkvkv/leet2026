class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque();

        for(char ele:s.toCharArray()) {
            if(stack.peek()!=null) {
                int[] top = stack.getLast();
                if(top[0] == (int)ele) {
                    top[1]++;
                    if(top[1]==k) {
                        stack.removeLast();
                    }
                } else {
                    stack.add(new int[]{ele,1});
                }
            } else {
                stack.add(new int[]{ele,1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] ele:stack) {
            for(int i = 0; i<ele[1];i++) {
                sb.append((char)ele[0]);
            }
        }
        return sb.toString();
    }
}
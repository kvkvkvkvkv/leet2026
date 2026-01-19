class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        for(int ele:asteroids) {
            if(ele>0) {
                stack.push(ele);
            } else {
                while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<-ele) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0) {
                    stack.add(ele);
                } else {
                    if(stack.peek()==-ele) {
                        stack.pop();
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        int index =stack.size()-1;
        while(!stack.isEmpty()) {
            ans[index--] = stack.pop();
        }
        return ans;
    }
}
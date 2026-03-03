class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] next = new int[nums.length*2];

        for(int i=0;i<nums.length;i++) {
            next[i] = nums[i];
            next[i+nums.length] = nums[i];
        }
        return next;
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }

        for(int i=nums.length-1;i>=0;i--) {
            if(nums[index]<nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, index+1, nums.length-1);
    }

    void reverse(int[] nums, int l, int r) {
        while(l<r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }
}
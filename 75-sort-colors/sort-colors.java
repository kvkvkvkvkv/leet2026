class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length-1;

        while(m<=h) {
            if(nums[l]==0) {
                l++;
                if(l-1 == m) {
                    m++;
                }
                continue;
            }

            if(nums[h]==2) {
                h--;
                continue;
            }

            if(nums[m]==1) {
                m++;
                continue;
            }

            if(nums[m]==0) {
                int temp = nums[m];
                nums[m] = nums[l];
                nums[l] = temp;
                continue;
            }

            if(nums[m]==2) {
                int temp = nums[m];
                nums[m] = nums[h];
                nums[h] = temp;
                continue;
            }
        }
    }
}
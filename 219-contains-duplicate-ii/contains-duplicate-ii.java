class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();

        for(int index=0;index<nums.length;index++) {
            if(map.containsKey(nums[index])) {
                if(index-map.get(nums[index])<=k) {
                    return true;
                }
            }
            map.put(nums[index],index);
        }
        return false;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length+1;
        List[] val = new List[n];
        int[] ans = new int[k];
        for(int index=0;index<n;index++) {
            val[index] = new ArrayList<Integer>();
        }

        Map<Integer, Integer> count = new HashMap();

        for(int ele:nums) {
            count.putIfAbsent(ele, 0);
            count.put(ele, count.get(ele)+1);
        }

        for(int key:count.keySet()) {
            val[count.get(key)].add(key);
        }

        int i = 0;
        for(int index=n-1;index>=0 && k>0;index--) {
            List<Integer> cur = val[index];

            for(int ele: cur) {
                ans[i++] = ele;
                k--;
                if(k==0) {
                    break;
                }
            }
        }

        return ans;
    }
}
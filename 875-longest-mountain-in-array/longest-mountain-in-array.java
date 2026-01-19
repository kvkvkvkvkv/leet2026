class Solution {
    public int longestMountain(int[] arr) {
        
        int i=0;
        int n = arr.length;
        int ans = 0;
        while(i<n) {
            int start = i;
            while(i+1<n && arr[i]<arr[i+1]) {
                i++;
            }

            if(start == i) {
                i++;
                continue;
            }

            int down = i;
            while(i+1<n && arr[i]>arr[i+1]) {
                i++;
            }

            if(down == i) {
                i++;
                continue;
            }

            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}
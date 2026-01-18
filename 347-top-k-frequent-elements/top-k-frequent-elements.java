class Solution {
    int[] unique;
    Map<Integer,Integer> freq;
    public int[] topKFrequent(int[] nums, int k) {
        freq = new HashMap();
        for(int ele:nums) {
            freq.put(ele, freq.getOrDefault(ele,0)+1);
        }    
        unique = new int[freq.size()];
        int index=0;
        for(int key:freq.keySet()) {
            unique[index++] = key;
        }
        quickSelect(0, unique.length-1, unique.length-k);
        return Arrays.copyOfRange(unique, unique.length-k, unique.length);
    }
 
    void quickSelect(int left, int right, int kIndex) {

        if(left == right) {
            return;
        }
        int pivot = right;
        int position = partition(left, right, pivot);

        if(kIndex == position) {
            return;
        } if(kIndex < position) {
            quickSelect(left, position-1, kIndex);
        } else {
            quickSelect(position+1, right, kIndex);
        }
    }

    int partition(int left, int right, int pivot) {
        int pFreq = freq.get(unique[pivot]);
        int store = left;
        for(int i=left;i<=right;i++) {
            int num = unique[i];
            if(freq.get(num)<pFreq) {
                swap(i,store);
                store++;
            }
        }
        swap(store, pivot);
        return store;
    }

    void swap(int x, int y) {
        int temp = unique[x];
        unique[x] = unique[y];
        unique[y] = temp;
    }

}
class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> generate(int numRows) {
       gen(numRows);
       return ans; 
    }

    public List<Integer> gen(int numRows) {
        if(numRows == 1) {
            ans.add(Arrays.asList(1));
            return Arrays.asList(1);
        }

        List<Integer> prev=gen(numRows-1);
        List<Integer> temp = new ArrayList();
        for(int i=0;i<numRows;i++) {
            if(i==0 || i==numRows-1) {
                temp.add(1);
                continue;
            }
            temp.add(prev.get(i-1)+prev.get(i));
        }
        ans.add(temp);
        return temp;
    }
}
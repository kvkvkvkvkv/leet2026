class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer,Integer>> pacificCells = new HashSet();
        Set<Pair<Integer,Integer>> atlanticCells = new HashSet();
        for(int i=0;i<heights[0].length;i++) {
            dfs(0,i,pacificCells, heights, -1);
            dfs(heights.length-1,i,atlanticCells, heights, -1);
        }

        for(int i=0;i<heights.length;i++) {
            dfs(i,0,pacificCells, heights, -1);
            dfs(i,heights[0].length-1,atlanticCells, heights, -1);
        }

        List<List<Integer>> ans = new ArrayList();
        for(Pair<Integer,Integer> ele:pacificCells) {
            if(atlanticCells.contains(ele)) {
                ans.add(Arrays.asList(ele.getKey(),ele.getValue()));
            }
        }

        return ans;
    }

    void dfs(int r, int c, Set<Pair<Integer,Integer>> set, int[][] grid, int prev) {
        Pair<Integer,Integer> cur = new Pair(r,c);
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]<prev || set.contains(cur)) {
            return;
        }

        set.add(cur);
        dfs(r+1,c,set,grid,grid[r][c]);
        dfs(r-1,c,set,grid,grid[r][c]);
        dfs(r,c+1,set,grid,grid[r][c]);
        dfs(r,c-1,set,grid,grid[r][c]);
    }
}
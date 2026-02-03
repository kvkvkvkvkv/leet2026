class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    max = Math.max(max,count(grid, i, j));
                }
            }
        }
        return max;
    }

    public int count(int[][] grid, int r, int c) {
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0) {
            return 0;
        }

        grid[r][c] = 0;
        return 1 + count(grid, r+1, c) + count(grid, r-1, c) 
        + count(grid, r, c+1) + count(grid, r, c-1);
    }
}
class Solution {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> rotten = new LinkedList<>();
        boolean good = false;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    rotten.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    good = true;
                }
            }
        }

        if(rotten.isEmpty()) {
            return good?-1:0;
        }

        int count = 0;
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            while(size>0) {
                int[] orange = rotten.poll();
                for(int[] dir:direction) {
                    int r = dir[0] + orange[0];
                    int c = dir[1] + orange[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length 
                    && grid[r][c]==1) {
                        grid[r][c] = 2;
                        rotten.add(new int[]{r,c});
                    }
                }
                size--;
            }
            count++;
        }

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return count-1;
    }
}
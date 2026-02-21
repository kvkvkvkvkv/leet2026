class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j,0});
                }
            }
        }

        boolean[][] seen = new boolean[m][n];
        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int[] d:dir) {
                int r = d[0]+top[0];
                int c = d[1]+top[1];

                if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==1 && !seen[r][c]) {
                    seen[r][c] = true;
                    mat[r][c] = top[2] +1;
                    q.add(new int[]{r,c,mat[r][c]});
                }
            }
        }

        return mat;
    }
}
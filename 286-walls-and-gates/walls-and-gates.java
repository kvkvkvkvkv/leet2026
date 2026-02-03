class Solution {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> gates = new LinkedList<>();
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
                if(rooms[i][j] == 0) {
                    gates.add(new int[]{i,j,0});
                }
            }
        }

        while (!gates.isEmpty()) {
            int[] currentGate = gates.poll();
            for(int[] dir:direction) {
                int r = dir[0]+currentGate[0];
                int c = dir[1]+currentGate[1];

                if(r>=0 && c>=0 && r<rooms.length && c<rooms[0].length
                && rooms[r][c] == Integer.MAX_VALUE) {
                    rooms[r][c] = 1 + currentGate[2];
                    gates.add(new int[]{r,c,rooms[r][c]});
                }
            }
        }
    }
}
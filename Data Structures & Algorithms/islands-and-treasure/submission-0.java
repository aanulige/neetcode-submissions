class Solution {
    public int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1,0}};
    public int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        //queue
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                queue.offer(new int[]{i,j});
            }
        }
        
        //for each cell 0,  flag the dis = 0;
        // other cells dist = the distance to the closet cell 0
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for(int[] dir : direction){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == INF){
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

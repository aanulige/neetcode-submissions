class Solution {
    public int[] move = new int[]{-1, 0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int min = 0;
        while(!queue.isEmpty()){
            boolean rotOccurred = false;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for(int j = 0; j < 4; j++){
                    int nx = x + move[j];
                    int ny = y + move[j + 1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});   
                        rotOccurred = true;
                        fresh--;
                    }

                }
                
            }
            if (rotOccurred) min++;
        }
        return fresh == 0 ? min : -1;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
    
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacificReach = new boolean[n][m];
        boolean[][] atlanticReach = new boolean[n][m];
        //dfs for pacific

        for(int i = 0; i < n; i++){
            dfs(heights, pacificReach, i, 0);
            dfs(heights, atlanticReach, i, m - 1);
        }
        for(int i = 0; i < m; i++){
            dfs(heights, pacificReach, 0, i);
            dfs(heights, atlanticReach, n - 1,i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacificReach[i][j] && atlanticReach[i][j]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    public int[] move = new int[]{-1, 0, 1, 0, -1};

    public void dfs(int[][] heights, boolean[][] reach, int i, int j){
        reach[i][j] = true;
        for(int k = 0; k < 4; k++){
            int nx = i + move[k];
            int ny = j + move[k + 1];
            if(nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length 
                || reach[nx][ny] || heights[nx][ny] < heights[i][j]){
                continue;
            }
            dfs(heights, reach, nx, ny);   
        }
    }
}

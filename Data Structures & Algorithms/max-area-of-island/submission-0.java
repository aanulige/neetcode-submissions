class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int nres = dfs(grid, i, j, n, m);
                    res = Math.max(res, nres);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int res = 1;
        res += dfs(grid, i + 1, j, n, m);
        res += dfs(grid, i - 1, j, n, m);
        res += dfs(grid, i , j + 1, n, m);
        res += dfs(grid, i , j - 1, n, m);
        return res;
    }
}

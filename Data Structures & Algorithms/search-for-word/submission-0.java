class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] w, int k){
        if(k == w.length){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0|| j >= board[0].length || board[i][j] != w[k]){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = 0;

        boolean res = dfs(board, i + 1, j, w, k + 1) ||
                    dfs(board, i - 1, j, w, k + 1) ||
                    dfs(board, i , j + 1, w, k + 1) ||
                    dfs(board, i, j - 1, w, k + 1);
        board[i][j] = temp;
        return res;
    }
}

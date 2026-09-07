class Solution {

    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Word completely found
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char original = board[row][col];
        board[row][col] = '#';

        // Explore 4 directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) || // up
                dfs(board, word, row + 1, col, index + 1) || // down
                dfs(board, word, row, col - 1, index + 1) || // left
                dfs(board, word, row, col + 1, index + 1);   // right

        // Backtrack
        board[row][col] = original;

        return found;
    }
}
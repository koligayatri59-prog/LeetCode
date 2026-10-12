class Solution {
    public boolean exist(char[][] board, String word) {
       boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean find(int row, int col, int idx,
                               char[][] board, String word,
                               boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(idx) ||
            visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        boolean up = find(row - 1, col, idx + 1, board, word, visited);
        boolean down = find(row + 1, col, idx + 1, board, word, visited);
        boolean left = find(row, col - 1, idx + 1, board, word, visited);
        boolean right = find(row, col + 1, idx + 1, board, word, visited);

        visited[row][col] = false;

        return up || down || left || right;
    }
 
    }



class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        solve(0, arr);
        return ans;
    }

    public void solve(int row, int[][] arr) {

        if (row == arr.length) {
            List<String> board = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                String s = "";
                for (int j = 0; j < arr.length; j++) {
                    s += arr[i][j] == 1 ? "Q" : ".";
                }
                board.add(s);
            }

            ans.add(board);
            return;
        }

        for (int col = 0; col < arr.length; col++) {
            if (canSeat(row, col, arr)) {
                arr[row][col] = 1;

                solve(row + 1, arr);

                arr[row][col] = 0;
            }
        }
    }

    public boolean canSeat(int row, int col, int[][] arr) {

        for (int r = row; r >= 0; r--) {
            if (arr[r][col] == 1)
                return false;
        }

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (arr[r][c] == 1)
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >= 0 && c < arr.length) {
            if (arr[r][c] == 1)
                return false;
            r--;
            c++;
        }

        return true;
    }
}

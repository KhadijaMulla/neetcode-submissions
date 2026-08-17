class Solution {

    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[m][n];

        int good = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    good++;
                }
            }
        }

        int tm = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int rotten = 0;

        while (!q.isEmpty()) {

            Pair curr = q.peek();

            int r = curr.row;
            int c = curr.col;
            int t = curr.time;

            tm = Math.max(tm, t);

            q.remove();

            for (int i = 0; i < 4; i++) {

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < m &&
                    ncol >= 0 && ncol < n &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1) {

                    q.add(new Pair(nrow, ncol, t + 1));

                    vis[nrow][ncol] = 2;

                    rotten++;
                }
            }
        }

        if (rotten != good) {
            return -1;
        }

        return tm;
    }
}






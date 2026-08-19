class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Pacific: top row + left column
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, pacific);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pacific);
        }

        // Atlantic: bottom row + right column
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, heights, atlantic);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Cells reachable from both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int row, int col,
                    int[][] heights,
                    boolean[][] visited) {

        visited[row][col] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !visited[nr][nc] &&
                heights[nr][nc] >= heights[row][col]) {

                dfs(nr, nc, heights, visited);
            }
        }
    }
}
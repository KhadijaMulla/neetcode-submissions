class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] pat = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (!dfs(i, adj, vis, pat)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node,
                       ArrayList<ArrayList<Integer>> adj,
                       int[] vis,
                       int[] pat) {

        vis[node] = 1;
        pat[node] = 1;

        for (int it : adj.get(node)) {

            if (vis[it] == 0) {

                if (!dfs(it, adj, vis, pat)) {
                    return false;
                }

            } else if (pat[it] == 1) {
                return false;
            }
        }

        pat[node] = 0;

        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];

        if (dfs(0, -1, adj, vis)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int parent,
                       ArrayList<ArrayList<Integer>> adj,
                       int[] vis) {

        vis[node] = 1;

        for (int neighbor : adj.get(node)) {

            if (vis[neighbor] == 0) {

                if (dfs(neighbor, node, adj, vis)) {
                    return true;
                }

            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}
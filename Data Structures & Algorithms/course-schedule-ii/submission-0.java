class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (dfsCheck(i, adj, vis, pathVis, ans)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(numCourses - 1 - i);
        }

        return result;
    }

    public boolean dfsCheck(int node,
                            ArrayList<ArrayList<Integer>> adj,
                            int[] vis,
                            int[] pathVis,
                            ArrayList<Integer> ans) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {

            if (vis[it] == 0) {

                if (dfsCheck(it, adj, vis, pathVis, ans)) {
                    return true;
                }

            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;

        ans.add(node);

        return false;
    }
}
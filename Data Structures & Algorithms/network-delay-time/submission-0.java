class Solution {

    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Store graph
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new Pair(v, wt));
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min Heap
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.add(new Pair(k, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int distance = current.distance;

            for (Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;
                int weight = neighbor.distance;

                if (distance + weight < dist[nextNode]) {

                    dist[nextNode] = distance + weight;

                    pq.add(new Pair(
                        nextNode,
                        dist[nextNode]
                    ));
                }
            }
        }

        // Find maximum shortest distance
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
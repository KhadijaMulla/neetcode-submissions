class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);

        map.put(node, clone);
        q.add(node);

        while (!q.isEmpty()) {

            Node curr = q.remove();

            for (Node neighbor : curr.neighbors) {

                if (!map.containsKey(neighbor)) {

                    map.put(neighbor, new Node(neighbor.val));

                    q.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return clone;
    }
}
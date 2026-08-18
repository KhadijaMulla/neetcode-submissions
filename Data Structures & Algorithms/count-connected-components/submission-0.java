class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int vis[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;

                dfs(i,adj,vis);
            }
        }
        return count;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>>adj,int[]vis){
        vis[node]=1;
        for(int neighbor:adj.get(node)){
            if(vis[neighbor]==0){
                dfs(neighbor,adj,vis);
            }
        }
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n==1 || source==destination)
            return true;
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int i=0; i< edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }
        boolean[] visited = new boolean[n];
        return dfs(source,destination,visited,adj);
    }
    
    private boolean dfs(int current, int destination, boolean[] visited, List<Integer>[] adj){
        if(visited[current])
            return false;
        if(current==destination)
            return true;
        visited[current]=true;
        List<Integer> neighbours = adj[current];
        for(int neighbour : neighbours)
            if(dfs(neighbour,destination,visited, adj))
                return true;
        return false;
    }
}
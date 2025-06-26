class Solution {
    void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] arr) {

        if (visited[node])
            return;

        visited[node] = true;
        arr[0]++;

        for (int i=0; i<adj.get(node).size(); i++) {
            arr[1]++;
            dfs(adj.get(node).get(i), adj, visited, arr);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int numComponents = 0;

        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        // Form Adjacency list for undirected graph
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                // 0th index is no. of nodes, and 1st index is no. of edges in the component
                int[] arr = new int[2];

                dfs(i, adj, visited, arr);
                    
                // we are double counting the edges so, e = (v * (v-1))
                // if not double counted, then no. of edges e = (v * (v-1))/2
                if (arr[1] == (arr[0] * (arr[0]-1)))
                    numComponents++;
            }
        }
        
        return numComponents;
    }
}
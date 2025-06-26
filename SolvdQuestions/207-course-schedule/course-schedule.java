class Solution {

    boolean isCyclic(int node, List<List<Integer>> adj, boolean[] visited, boolean[] inPath) {

        if (inPath[node]) 
            return true;

        if (visited[node])  // Skip if already processed
            return false;

        inPath[node] = true;

        for (int i=0; i<adj.get(node).size(); i++) {
            if(isCyclic(adj.get(node).get(i), adj, visited, inPath))
                return true;
        }

        inPath[node] = false;
        visited[node] = true;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Form adj list
        for (int i=0; i<prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, inPath)) {
                    return false;
                }
            }
        }

        return true;
    }
}
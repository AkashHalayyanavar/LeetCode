class Solution {

    int maxLen = 1;
    int dfs(int node, List<List<Integer>> adj, String s) {

        // System.out.println("Node: " + node);

        int max1=0, max2=0;

        for (int i=0; i<adj.get(node).size(); i++) {
            int len = dfs(adj.get(node).get(i), adj, s);
            len = s.charAt(adj.get(node).get(i)) == s.charAt(node) ? -1 : len;
            if (max1 <= max2)
                max1 = Math.max(max1, len+1);
            else
                max2 = Math.max(max2, len+1);

            maxLen = Math.max(maxLen, max1+max2+1);
        }

        return Math.max(max1, max2);
    }

    public int longestPath(int[] parent, String s) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = parent.length;
        
        for (int i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for (int i=0; i<n; i++)
            if (parent[i] != -1)
                adj.get(parent[i]).add(i);

        // for (List<Integer> list : adj)
        //     System.out.println(list.toString());

        dfs(0, adj, s);

        return maxLen;
    }
}
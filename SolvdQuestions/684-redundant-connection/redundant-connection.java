class Solution {
    int getParent(int node, List<Integer> parent) {
        if (parent.get(node) == node) {
            return node;
        }

        parent.set(node, getParent(parent.get(node), parent));
        return parent.get(node);
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        // Initialize parent to -1
        for (int i=0; i<=n; i++) {
            parent.add(i);
            rank.add(0);
        }

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];

            int pParent = getParent(p, parent);
            int qParent = getParent(q, parent);

            if (pParent!=qParent) {
                if (rank.get(pParent) >= rank.get(qParent)) {
                    parent.set(qParent, pParent);
                    rank.set(pParent, rank.get(qParent)+1);
                } else {
                    parent.set(pParent, qParent);
                    rank.set(qParent, rank.get(pParent)+1);
                }
            } else {
                return new int[]{p,q};
            }
        }

        return new int[]{0,0};
        
    }
}
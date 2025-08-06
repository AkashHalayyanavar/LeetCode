class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        boolean[] placed = new boolean[n];
        int count = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (placed[j] == false && baskets[j] >= fruits[i]) {
                    placed[j] = true;
                    break;
                }
            }
        }

        for (int i=0; i<n; i++)
            if (placed[i] == false)
                count++;

        return count;
    }
}
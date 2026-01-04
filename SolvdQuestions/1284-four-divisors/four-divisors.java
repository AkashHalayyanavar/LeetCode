class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;

        for (int num: nums) {
            Set<Integer> set = new HashSet<>();

            for (int i=1; i<=Math.sqrt(num); i++) {
                if (num%i == 0) {
                    set.add(i);
                    set.add(num/i);
                }
            }

            if (set.size() == 4) {
                for (int element: set) {
                    sum += element;
                }
            }
        }

        return sum;
    }
}
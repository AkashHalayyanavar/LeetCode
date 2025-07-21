class Solution {

    void getCombinations(int start, int end, int target, int[] candidates, List<List<Integer>> result, List<Integer> currList) {

        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        if (start > end || target < 0)
            return;

        currList.add(candidates[start]);
        getCombinations(start+1, end, target-candidates[start], candidates, result, currList);
        currList.removeLast();
        // handle duplicates (Same element should not be picked at the same position)
        while (start+1 <= end && candidates[start+1] == candidates[start])
            start++;
            
        getCombinations(start+1, end, target, candidates, result, currList);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();


        Arrays.sort(candidates);

        getCombinations(0, candidates.length-1, target, candidates, result, new ArrayList<>());

        return result;
    }
}
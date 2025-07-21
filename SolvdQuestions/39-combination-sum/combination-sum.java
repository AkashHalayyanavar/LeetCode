class Solution {

    void getCombinations(int start, int end, int target, int[] candidates, List<List<Integer>> result, List<Integer> currList) {

        if (start > end || target < 0)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(candidates[start]);
        getCombinations(start, end, target-candidates[start], candidates, result, currList);
        currList.removeLast();
        getCombinations(start+1, end, target, candidates, result, currList);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        getCombinations(0, candidates.length-1, target, candidates, result, new ArrayList<>());
        return result;
    }
}
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> list,
                           List<List<Integer>> ans) {

        // Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Invalid case
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Choose current element
        list.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], list, ans);

        // Backtrack
        list.remove(list.size() - 1);

        // Skip current element
        backtrack(index + 1, candidates, target, list, ans);
    }
}
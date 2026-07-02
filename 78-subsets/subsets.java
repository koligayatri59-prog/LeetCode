class Solution {

    void solve(int index, int[] nums,
               List<List<Integer>> ans,
               List<Integer> temp) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Take
        temp.add(nums[index]);
        solve(index + 1, nums, ans, temp);
        temp.remove(temp.size() - 1);

        // Not Take
        solve(index + 1, nums, ans, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(0, nums, ans, temp);

        return ans;
    }
}
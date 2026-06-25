class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void helper(int[] nums, int i,
                        List<Integer> curr,
                        List<List<Integer>> ans) {

        if (i == nums.length) {
            if (!set.contains(curr)) {
                set.add(new ArrayList<>(curr));
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        
        curr.add(nums[i]);
        helper(nums, i + 1, curr, ans);

    
        curr.remove(curr.size() - 1);
        helper(nums, i + 1, curr, ans);
    }
}
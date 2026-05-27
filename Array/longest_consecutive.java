class Solution {
    public int longestConsecutive(int[] nums) {

        List<Integer> list2 = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            list2.clear();
            if (!hs.contains(nums[i] - 1)) {

                int current = nums[i];

                list2.add(current);

                while (hs.contains(current + 1)) {
                    current++;
                    list2.add(current);
                }

                int max2 = list2.size();

                max = Math.max(max2, max);
            }
        }

        return max;
    }
}

// Store all numbers in HashSet for fast lookup.
// Start sequence only if previous number does not exist.
// Count consecutive numbers using while loop.
// Track and return the maximum sequence length.
```
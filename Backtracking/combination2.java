class Solution {

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getCombine(candidates, 0, target, list, list2);

        return list;
    }

    public void getCombine(int[] candidates, int i, int target,
                           List<List<Integer>> list,
                           List<Integer> list2) {

        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list2);

            if (!set.contains(temp)) {
                list.add(temp);
                set.add(temp);
            }
            return;
        }

        if (i >= candidates.length || target < 0) {
            return;
        }

    
        list2.add(candidates[i]);
        getCombine(candidates, i + 1, target - candidates[i], list, list2);

        list2.remove(list2.size() - 1);

 
        int next = i + 1;
        while (next < candidates.length &&
               candidates[next] == candidates[i]) {
            next++;
        }


        getCombine(candidates, next, target, list, list2);
    }
}

// when in question ask for not to use the same number again, we can use while loop to skip the same number after the removal of the last number in the list. This way, we ensure that we do not consider the same number again in the next recursive call, thus avoiding duplicates in our combinations.
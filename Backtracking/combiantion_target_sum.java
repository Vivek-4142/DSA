class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> list = new ArrayList<>();
       List<Integer> list2 = new ArrayList<>();

       getCombine(nums,0,target,list,list2);
       return list; 
    }
    public void getCombine(int[]nums,int i, int target,List<List<Integer>> list,List<Integer> list2){
        if(i==nums.length || target < 0){
            return;
        }
        if(target == 0){
            if(!set.contains(list2)){
            list.add(new ArrayList<>(list2));
            set.add(list2);
            return;
            }
        }
        list2.add(nums[i]);
        getCombine(nums,i+1,target-nums[i],list,list2);
        getCombine(nums,i,target-nums[i],list,list2);
        list2.remove(list2.size()-1);
        getCombine(nums,i+1,target,list,list2);
    }
}

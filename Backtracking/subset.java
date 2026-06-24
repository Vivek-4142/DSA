class Solution {
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getallsub(nums,0,list,list2);
        return list;
    }
     public void getallsub(int[]nums,int i,List<List<Integer>> list, List<Integer>list2){
        if(i>=nums.length){
            list.add(new ArrayList<>(list2));
            return;
        }
        list2.add(nums[i]);
        getallsub(nums,i+1,list,list2);
        list2.remove(list2.size()-1);
        getallsub(nums,i+1,list,list2);
    }
}

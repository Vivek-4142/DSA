class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
       
        getPer(nums,0,list);
        return list;

    }
    public void getPer(int[]nums,int i ,List<List<Integer>> list){
        if(i == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            list.add(temp);
            return;
        }
        for(int j =i;j<nums.length;j++){
            swap(nums,i,j);
            getPer(nums,i+1,list);
            swap(nums,j,i);
        }
    }
   public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

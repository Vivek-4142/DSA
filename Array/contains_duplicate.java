class Solution {
    public boolean hasDuplicate(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int count = 0;
       for(int i = 0 ; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

       } 
        for(int i = 0 ; i<nums.length;i++){
            if(map.get(nums[i])>1){
                return true;
            }

       }

       return false; 
    }
}
    // Problem: Contains Duplicate
    // Topic: Arrays, Hashing
    // Approach:
    // Use a HashSet to store visited elements.
    // If an element already exists in the set,
    // duplicate is found.

    // Time Complexity: O(n)
    // Space Complexity: O(n)
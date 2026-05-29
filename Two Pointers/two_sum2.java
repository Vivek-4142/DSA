
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            if(numbers[left]+numbers[right]>target){
                right--;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }
            

            
        }
        return new int[]{};
    }
}
// Time Complexity: O(n), where n is the length of the input array. In the worst case, we may need to traverse the entire array once.
// Space Complexity: O(1), as we are using only a constant amount of extra space for the two pointers and temporary variables. We are not using any additional data structures that grow with the input size.           
// The two-pointer approach is efficient for this problem because the input array is sorted, allowing us to adjust the pointers based on the sum compared to the target.

class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int max = 0;
        while(left<right){
            int width = right - left;
            int curr = Math.min(heights[left],heights[right]) * width;
            max = Math.max(curr,max);

            if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
// Time Complexity: O(n), where n is the length of the input array. We traverse the array once with two pointers.
// Space Complexity: O(1), as we are using only a constant amount of extra space
// The two-pointer approach is efficient for this problem because it allows us to calculate the area of water that can be contained between the two pointers and then move the pointer that has the smaller height. This is based on the fact that the area is limited by the shorter line, so moving the pointer with the smaller height may lead to a larger area. By iterating through the array in this way, we can find the maximum area of water that can be contained efficiently.
class Solution {
    public int trap(int[] height) {
        int [] left = new int [height.length];
        int [] right = new int [height.length];
        left[0]=height[0];
        for(int i =1;i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        right[height.length-1] = height[height.length-1];
         for(int i = height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }

        int trapped = 0;
        for(int i =0;i<height.length;i++){
            trapped += Math.min(left[i],right[i])-height[i];
        }

        return trapped;
    }
}
// Time Complexity: O(n), where n is the length of the input array. We traverse the array three times: once to fill the left array, once to fill the right array, and once to calculate the trapped water.
// Space Complexity: O(n), as we are using two additional arrays (left and right)
// to store the maximum heights to the left and right of each position. The space used by these arrays is proportional to the input size.
// find the maximum height to the left and right of each position, we can determine how much water can be trapped at that position by taking the minimum of the two heights and subtracting the height of the current position. This approach allows us to efficiently calculate the total amount of trapped water.
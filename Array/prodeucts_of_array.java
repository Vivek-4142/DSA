class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int multi = 1;

            for (int j = 0; j < nums.length; j++) {

                if (i != j) {
                    multi *= nums[j];
                }
            }

            arr[i] = multi;
        }

        return arr;
    }
}

// Brute-force approach: For each element, calculate the product of all other elements.
// Time complexity: O(n^2) due to nested loops. 
// Space complexity: O(n) for the output array. 
// Optimized approach using prefix and suffix products:
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Calculate prefix products
        output[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        // Calculate suffix products and multiply with prefix products
        int suffixProduct = 1; // No elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return output;
    }
}
// Calculate prefix products in the first pass and store them in the output array.
// In the second pass, calculate suffix products on the fly and multiply with the prefix products in the output array.
// Time complexity: O(n) due to two passes through the array.
// Space complexity: O(1) if we don't count the output array, which is required for the result.

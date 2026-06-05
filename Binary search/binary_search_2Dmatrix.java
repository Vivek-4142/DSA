class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int left =0;
        int right = n*m -1;
        while(left<=right){
            int mid = (left+right)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return false;
    }
}

// for row = index/m and col = index%m; we can find the row and column of the mid element in the 2D matrix. This way we can apply binary search on the 2D matrix as if it is a 1D array.
//for row length n and column length m, the total number of elements in the matrix is n*m. So we can treat the matrix as a 1D array of size n*m and apply binary search on it. The mid element can be found using the formula mid = (left + right)/2, and then we can find the corresponding row and column using the formulas row = mid/m and col = mid%m. This way we can efficiently search for the target element in the 2D matrix.
// for row = matrix.length and col = matrix[0].length; we can find the number of rows and columns in the matrix. This way we can determine the total number of elements in the matrix and apply binary search on it. The mid element can be found using the formula mid = (left + right)/2, and then we can find the corresponding row and column using the formulas row = mid/m and col = mid%m. This way we can efficiently search for the target element in the 2D matrix.   
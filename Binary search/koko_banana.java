class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int left =1;
        int right = max;
        while(left<=right){
            int mid =(left+right)/2;
            int ban = banana(piles,mid);
            if(ban<=h){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    public int banana(int[] piles,int mid){
        int ban =0;
        for(int i =0;i<piles.length;i++){
            ban += Math.ceil((double)piles[i]/mid); 
        }

        return ban;
    }
}

// // MATH.ceil((double)piles[i]/mid) is used to calculate the number of hours needed to eat the bananas in the current pile at the given speed (mid). The Math.ceil function rounds up the result to the nearest integer, which is necessary because if there are any remaining bananas after dividing by mid, it will still take an additional hour to eat them. By using Math.ceil, we ensure that we account for any partial hours needed to finish eating the bananas in the current pile.
// // ban += Math.ceil((double)piles[i] / mid);

// // Suppose:

// // piles[i] = 7;
// // mid = 3;
// // Step 1: Convert to double
// // (double)piles[i]

// becomes:

// 7.0

// Now:

// 7.0 / 3

// gives:

// 2.3333333333333335

// If you didn't cast to double:

// 7 / 3

// Java would perform integer division and give:

// 2
// Step 2: Apply Math.ceil()
// Math.ceil(2.3333333333333335)

// returns:

// 3.0
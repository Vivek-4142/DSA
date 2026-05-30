public class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// Explanation: We use two pointers, l and r, to traverse the array. The left pointer (l) represents the buying day, and the right pointer (r) represents the selling day. We calculate the profit for each pair of days and update the maximum profit accordingly. If we find a lower price at r than at l, we move the left pointer to r, as it may represent a better buying opportunity.
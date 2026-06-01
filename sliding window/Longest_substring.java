class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        HashSet<Character> hs = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {

            if (!hs.contains(s.charAt(right))) {

                hs.add(s.charAt(right));

                max = Math.max(max, right - left + 1);

                right++;

            } else {

                hs.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}
//
// Time Complexity: O(n)
// Space Complexity: O(min(m, n)), where m is the size of the character set
// Explanation: We use a sliding window approach with two pointers (left and right) to traverse the string. We maintain a HashSet to keep track of the characters in the current window. If the character at the right pointer is not in the HashSet, we add it and update the maximum length of the substring. If it is already in the HashSet, we remove the character at the left pointer and move the left pointer to shrink the window until we can add the new character. This way, we ensure that all characters in the current window are unique.
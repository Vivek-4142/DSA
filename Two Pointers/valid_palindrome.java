class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        String string = sb.reverse().toString();
       return s.equals(string);
    }
}


// Two Pointers Approach
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters at left and right pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Not a palindrome
            }

            left++;
            right--;
        }

        return true; // It's a palindrome
    }
}

// Time Complexity: O(n), where n is the length of the string. We traverse the string at most once.
// Space Complexity: O(1), as we are using only a constant amount of extra space for the pointers and temporary variables.          
// The first solution uses additional space to create a new string and reverse it, while the second solution uses two pointers to compare characters in place without extra space.

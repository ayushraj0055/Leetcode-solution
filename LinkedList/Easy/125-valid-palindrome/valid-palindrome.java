class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Step 1: Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Step 2: Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step 3: Compare characters (case-insensitive)
            char chLeft = Character.toLowerCase(s.charAt(left));
            char chRight = Character.toLowerCase(s.charAt(right));

            if (chLeft != chRight) {
                return false;
            }

            // Step 4: Move pointers inward
            left++;
            right--;
        }

        return true;
    }
}

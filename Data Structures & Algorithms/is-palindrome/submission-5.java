class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) cleaned.append(s.charAt(i));
        }
        StringBuilder reversed = new StringBuilder(cleaned);
        reversed.reverse();

        return cleaned.toString().toLowerCase().equals(reversed.toString().toLowerCase());
    }
}

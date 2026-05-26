class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) cleaned.append(c);
        }
        return cleaned.toString().equalsIgnoreCase(cleaned.reverse().toString());
    }
}

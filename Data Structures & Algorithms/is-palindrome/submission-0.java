class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        while(start <= end) {
            while(start < end && !isAlphaNumeric(s.charAt(start))) start++;
            while(start < end && !isAlphaNumeric(s.charAt(end))) end--;
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}

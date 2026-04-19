/*
Problem: https://leetcode.com/problems/valid-palindrome/description/?envType=problem-list-v2&envId=oizxjoit
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0, n = s.length();
        Set<Character> unique = new HashSet<>();

        while (j < n) {
            char ch = s.charAt(j);
            if (!unique.contains(ch)) {
                ans = Math.max(ans, j - i + 1);
                unique.add(ch);
                j++;
            } else {
                while (unique.contains(ch)) {
                    char last = s.charAt(i);
                    unique.remove(last);
                    i++;
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int start = 0, end = 0;

        Set<Character> charSet = new HashSet<>();

        int maxLen = 0;

        while (end < n) {
            char ch = s.charAt(end);
            while (charSet.contains(ch) && start <= end) {
                char charAtStart = s.charAt(start);
                charSet.remove(charAtStart);
                start++;
            }

            charSet.add(ch);

            maxLen = Math.max(maxLen, end - start + 1);

            end++;
        }

        return maxLen;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        int reqChars = charMap.size();

        int formed = 0;

        int start = 0, end = 0;

        String minSubstring = "";
        int minLen = Integer.MAX_VALUE;

        while (end < n) {
            char ch = s.charAt(end);

            if (charMap.containsKey(ch)) {
                int cnt = charMap.get(ch);
                if (cnt == 1) {
                    formed++;
                }
                charMap.put(ch, cnt - 1);
            }

            while (formed == reqChars && start <= end) {
                char charAtStart = s.charAt(start);
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minSubstring = s.substring(start, end + 1);
                }

                if (charMap.containsKey(charAtStart)) {
                    int cnt = charMap.get(charAtStart);
                    if (cnt == 0) {
                        formed--;
                    }
                    charMap.put(charAtStart, cnt + 1);
                }

                start++;
            }


            end++;
        }

        return minSubstring;
    }
} 
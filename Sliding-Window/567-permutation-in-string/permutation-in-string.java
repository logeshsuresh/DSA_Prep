class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();

        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        int distinctCnt = charMap.size();

        int windowSize = s1.length();

        int start = 0, end = 0;

        while (end < n) {
            char ch = s2.charAt(end);
            while (end - start + 1 > windowSize && start <= end) {
                char charAtStart = s2.charAt(start);
                if (charMap.containsKey(charAtStart)) {
                    int cnt = charMap.get(charAtStart);
                    if (cnt == 0) {
                        distinctCnt++;
                    }
                    charMap.put(charAtStart, cnt + 1);
                }
                start++;
            }

            if (charMap.containsKey(ch)) {
                int cnt = charMap.get(ch);
                if (cnt == 1) {
                    distinctCnt--;
                }
                charMap.put(ch, cnt - 1);
            }

            if (end - start + 1 == windowSize) {
                if (distinctCnt == 0) { return true; }
            }

            end++;
        }

        return false;
    }
}
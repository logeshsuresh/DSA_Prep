class Solution {
    public String removeDuplicateLetters(String s) {  
        int n = s.length();

        int[] lastOccur = new int[26];

        Set<Character> seen = new HashSet<>();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            lastOccur[curChar - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (seen.contains(ch)) {
                continue;
            } else {
                while (!stack.isEmpty() && ch < stack.peek() && lastOccur[stack.peek() - 'a'] > i) {
                    char charToRemove = stack.peek();
                    seen.remove(charToRemove);
                    stack.pop();
                }
                seen.add(ch);
                stack.push(ch);
            }
        }

        String output = "";

        while (!stack.isEmpty()) {
            output = stack.pop() + output;
        }

        return output;
    }
};
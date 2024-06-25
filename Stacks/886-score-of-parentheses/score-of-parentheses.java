class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int curVal = 0;
                while (!stack.isEmpty() && stack.peek() != 0) {
                    curVal += stack.pop();
                }
                stack.pop();
                curVal = (curVal == 0) ? 1 : (2 * curVal);
                stack.push(curVal);
            }
        }

        int totalScore = 0;

        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }

        return totalScore;
    }
}
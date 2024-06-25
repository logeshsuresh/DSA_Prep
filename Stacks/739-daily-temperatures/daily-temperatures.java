class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<Pair> stack = new Stack<>();

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().temp) {
                Pair p = stack.pop();
                int index = p.index, temp = p.temp;
                answer[index] = i - index;
            }
            stack.push(new Pair(i, temperatures[i]));
        }

        return answer;
    }
}

class Pair {
    int index;
    int temp;
    public Pair(int index, int temp) {
        this.index = index;
        this.temp = temp;
    }
}
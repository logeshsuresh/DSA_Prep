class MinStack {

    Stack<Pair> stack;
    private static final int INF = Integer.MAX_VALUE;

    public MinStack() { stack = new Stack<>(); }
    
    public void push(int val) {
        int curMin = (stack.isEmpty()) ? INF : stack.peek().getCurMin();
        int min = Math.min(val, curMin);
        stack.push(new Pair(val, min));
    }
    
    public void pop() { stack.pop(); }
    
    public int top() { return stack.peek().getCurElement(); }
    
    public int getMin() { return stack.peek().getCurMin(); }
}

class Pair {
    private int curElement;
    private int curMin;

    public Pair(int curElement, int curMin) {
        this.curElement = curElement;
        this.curMin = curMin;
    }

    public void setCurElement(int curElement) { this.curElement = curElement; }

    public void setCurMin(int curMin) { this.curMin = curMin; }

    public int getCurElement() { return this.curElement; }

    public int getCurMin() { return this.curMin; }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
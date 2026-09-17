class MinStack {
    int [] arr;
    int top = -1;
    public MinStack() {
        arr = new int[30000];
    }

    public void push(int value) {
        top++;
        arr[top] = value;
    }

    public void pop() {
        int add = arr[top];
        top--;
    }

    public int top() {
       return arr[top];
    }

    public int getMin() {
          int min = Integer.MAX_VALUE;

        for (int i = 0; i <= top; i++) {
            min = Math.min(min, arr[i]);
        }

        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
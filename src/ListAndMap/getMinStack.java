package ListAndMap;

import java.util.Stack;

//获取栈中最小元素
public class getMinStack {

    public static class minStack{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public minStack(Stack<Integer> stack, Stack<Integer> minStack) {
            this.stack = stack;
            this.minStack = minStack;
        }

        public minStack() {
        }

        public int getMin(){
            return minStack.peek();
        }

        public void push(int value){
            int lastValue = value;
            if (!minStack.isEmpty()){
                lastValue = minStack.peek();
            }
            if (lastValue < value){
                minStack.push(lastValue);
            } else {
                minStack.push(value);
            }
            stack.push(value);
        }

        public int pop(){
            minStack.pop();
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        minStack s = new minStack(new Stack<>(), new Stack<>());
        s.push(5);
        s.push(1);
        s.push(2);
        s.push(9);
        s.push(3);
        System.out.println(s.getMin());
    }

}

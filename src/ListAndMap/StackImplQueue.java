package ListAndMap;

import java.util.Stack;

public class StackImplQueue<T> {
    private Stack<T> pushStack;
    private Stack<T> popStack;

    public StackImplQueue() {
    }

    public StackImplQueue(Stack<T> pushStack, Stack<T> popStack) {
        this.pushStack = pushStack;
        this.popStack = popStack;
    }

    public void push(T value){
        pushStack.push(value);
    }

    public T pop(){
        if (popStack.isEmpty()){
            //将pushStack中的数据放入popStack中
            pushToPop(pushStack, popStack);
        }
        return popStack.pop();
    }

    public void pushToPop(Stack<T> pushStack, Stack<T> popStack){
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    public static void main(String[] args) {
        StackImplQueue<Integer> queue = new StackImplQueue<>(new Stack<>(), new Stack<>());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

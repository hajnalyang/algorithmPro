package ListAndMap;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueImplStack<T> {
    private Queue<T> queue;
    private Queue<T> help;

    public QueueImplStack() {
    }

    public QueueImplStack(Queue<T> queue, Queue<T> help) {
        this.queue = queue;
        this.help = help;
    }

    public void push(T value){
        queue.add(value);
    }

    public T pop(){
        while (queue.size() > 1){
            help.add(queue.remove());
        }
        T res = queue.remove();
        queue.addAll(help);
        help.clear();
        return res;
    }

    public T peek(){
        while (queue.size() > 1){
            help.add(queue.remove());
        }
        T res = queue.remove();
        queue.addAll(help);
        queue.add(res);
        help.clear();
        return res;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
            System.out.println("test begin");
            QueueImplStack<Integer> myStack = new QueueImplStack<>(new LinkedList<>(), new LinkedList<>());
            Stack<Integer> test = new Stack<>();
            int testTime = 1000000;
            int max = 1000000;
            for (int i = 0; i < testTime; i++) {
                if (myStack.isEmpty()) {
                    if (!test.isEmpty()) {
                        System.out.println("Oops");
                    }
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else {
                    if (Math.random() < 0.25) {
                        int num = (int) (Math.random() * max);
                        myStack.push(num);
                        test.push(num);
                    } else if (Math.random() < 0.5) {
                        if (!myStack.peek().equals(test.peek())) {
                            System.out.println("Oops");
                        }
                    } else if (Math.random() < 0.75) {
                        if (!myStack.pop().equals(test.pop())) {
                            System.out.println("Oops");
                        }
                    } else {
                        if (myStack.isEmpty() != test.isEmpty()) {
                            System.out.println("Oops");
                        }
                    }
                }
            }

            System.out.println("test finish!");

        }
}

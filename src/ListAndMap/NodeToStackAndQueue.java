package ListAndMap;

import java.net.HttpRetryException;

//链表实现栈和队列
public class NodeToStackAndQueue {
    public static class DoubleNode<T>{
        private DoubleNode<T> last;
        private final T value;
        private DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    public class MyStack<T>{
        //栈底
        private DoubleNode<T> head;
        //栈顶
        private DoubleNode<T> tail;
        //栈长度
        private int length;

        public int getLength(){
            return length;
        }

        public void push(T value){
            DoubleNode<T> v = new DoubleNode<>(value);
            if (head == null){
                head = v;
                tail = v;
            } else {
                v.last = tail;
                tail.next = v;
                tail = v;
            }
            length ++;
        }

        public T pop(){
            if (head == null)return null;
            DoubleNode<T> temp = tail;
            if (head == tail){
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                temp.last = null;
            }
            length--;
            return temp.value;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    public class MyQueue<T>{
        //队列头
        private DoubleNode<T> head;
        //队列尾
        private DoubleNode<T> tail;
        //队列长度
        private int length;

        public int getLength(){
            return length;
        }

        public void push(T value){
            DoubleNode<T> v = new DoubleNode<>(value);
            if (head == null){
                head = v;
                tail = v;
            } else {
                v.last = tail;
                tail.next = v;
                tail = v;
            }
            length ++;
        }

        public T pop(){
            if (head == null)return null;
            DoubleNode<T> temp = head;
            if (head == tail){
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                temp.next = null;
            }
            length--;
            return temp.value;
        }

        public boolean isEmpty(){
            return head == null;
        }

    }
}

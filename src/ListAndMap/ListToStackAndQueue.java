package ListAndMap;

import java.util.Arrays;

//数组实现栈和队列
public class ListToStackAndQueue {

    public static class MyStack{
        private int[] value;
        private int length;
        private final int limit;
        private int headIndex;
        //下一个应该存放的下标
        private int tailIndex;

        public MyStack(int limit) {
            value = new int[limit];
            length = 0;
            headIndex = 0;
            tailIndex = 0;
            this.limit = limit;
        }

        public void push(int value){
            if (length == limit) throw new RuntimeException("栈满了，不能再加了");
            this.value[tailIndex] = value;
            tailIndex = nextIndex(tailIndex);
            length ++;
        }

        public int pop(){
            if (length == 0) throw new RuntimeException("栈已经空了，无法取出");
            //取出最后一个元素
            tailIndex = preIndex(tailIndex);
            int value = this.value[tailIndex];
            this.value[tailIndex] = 0;
            length --;
            return value;
        }

        //获取栈底的值
        public int getLast(){
            return value[preIndex(tailIndex)];
        }

        /**
         *
         * @param index 当前下标
         * @return 下一个下标
         */
        public int nextIndex(int index){
            return index < limit - 1 ? index + 1 : 0;
        }

        public int preIndex(int index){
            return index != 0 ? index - 1 : limit - 1;
        }
    }

    public static class MyQueue{
        private int[] value;
        private int length;
        private final int limit;
        private int headIndex;
        //下一个应该存放的下标
        private int tailIndex;

        public MyQueue(int limit) {
            value = new int[limit];
            length = 0;
            headIndex = 0;
            tailIndex = 0;
            this.limit = limit;
        }

        public void push(int value){
            if (length == limit) throw new RuntimeException("队列满了，不能再加了");
            this.value[tailIndex] = value;
            tailIndex = nextIndex(tailIndex);
            length ++;
        }

        public int pop(){
            if (length == 0) throw new RuntimeException("队列已经空了，无法取出");
            //取出第一个元素
            int value = this.value[headIndex];
            this.value[headIndex] = 0;
            headIndex = nextIndex(headIndex);
            length --;
            return value;
        }

        /**
         *
         * @param index 当前下标
         * @return 下一个下标
         */
        public int nextIndex(int index){
            return index < limit - 1 ? index + 1 : 0;
        }
    }

    public static void main(String[] args) {
//        MyStack stack = new MyStack(5);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println(Arrays.toString(stack.value));
//        System.out.println(stack.length);
//
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        System.out.println(Arrays.toString(stack.value));
//        System.out.println(stack.length);
//        System.out.println(stack.tailIndex);

        MyQueue queue = new MyQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(Arrays.toString(queue.value));

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(Arrays.toString(queue.value));
        System.out.println(queue.length);
    }
}

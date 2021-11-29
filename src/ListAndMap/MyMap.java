package ListAndMap;

//实现单链表
public class MyMap {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    public static class DoubleNode{
        private DoubleNode last;
        private int value;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    //  head
    //   a    ->   b    ->  c  ->  null
    //   c    ->   b    ->  a  ->  null
    // 单链表的反转
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双链表的反转
    //   a    <->   b    <->  c  <->  null
    //   c    <->   b    <->  a  <->  null
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node deleteValue(Node head, int value){
        while (head != null){
            if (head.value != value){
                break;
            }
            head = head.next;
        }
        //遍历的节点
        Node temp = head;
        //当前不为指定数值的节点
        Node pre = head;

        while (temp != null){
            //如果当前遍历的值需要删除，则将上一个不需要删除的节点与该节点的下一个节点连接
            if (temp.value == value){
                pre.next = temp.next;
            } else {
                //当前最后一个不需要删除的节点向后移动
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }

}

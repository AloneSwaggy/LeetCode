/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0731.java
 * @Description TODO
 * @createTime 2023年07月31日 23:17:00
 */

public class Test0731 {
    static class listNode {
        int val;
        listNode next;
        listNode() {}
        listNode(int val) { this.val = val; }
        listNode(int val, listNode next) { this.val = val; this.next = next; }
        void add(int newval) {
            listNode newNode = new listNode(newval);
            if(this.next == null)
                this.next = newNode;
            else
                this.next.add(newval);
        }
    }
    public void reorderList(listNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        listNode slow = head;
        listNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        listNode newHead = slow.next;
        slow.next = null;
        //第二个链表倒置
        newHead = reverseList(newHead);
        //链表节点依次连接
        while (newHead != null) {
            listNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }
    private listNode reverseList(listNode head) {
        if (head == null) {
            return null;
        }
        listNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null) {
            listNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        Test0731 test0731 = new Test0731();
       listNode head = new listNode(1);
       head.add(2);
       head.add(3);
       head.add(4);
       head.add(5);
       head.add(6);
        test0731.reorderList(head);
    }
}

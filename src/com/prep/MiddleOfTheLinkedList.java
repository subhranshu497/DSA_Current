package com.prep;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode result = fromMiddle(head);
    }

    private static ListNode fromMiddle(ListNode head) {
        ListNode slow =head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

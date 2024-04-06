package com.prep;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode result = reorderLinkedList(head);
    }

    private static ListNode reorderLinkedList(ListNode head) {
        return null;
    }
}

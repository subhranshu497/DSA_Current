package com.prep;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        int n =6;
        ListNode result = removeN(head,n);
    }

    private static ListNode removeN(ListNode head, int n) {
        ListNode current = head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        while(current !=null){
            if(current.val==n) prev.next = current.next;
            else prev = current;
            current = current.next;
        }
        return head;
    }
}
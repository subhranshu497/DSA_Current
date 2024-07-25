package com.prep;

public class DoubleNumberRepresentedLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        ListNode result = doubleIt(head);
        while(result !=null){
            System.out.print(result.val+"-->");
            result = result.next;
        }

    }

    private static ListNode doubleIt(ListNode head) {
        ListNode rev = reverseList(head);
        int carry =0;
        ListNode current = rev; //9-8-1
        ListNode prev = null;
        while (current != null) {
            int newValue = current.val * 2 + carry;
            current.val = newValue % 10; // 8-7-3
            if (newValue > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            prev = current;
            current = current.next;
        }
        if (carry != 0) {
            ListNode extraNode = new ListNode(carry);
            prev.next = extraNode;
        }
        ListNode result = reverseList(rev);

        return result;
    }
    //1->8->9
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = head;
        while(nextNode !=null){
            nextNode = current.next;
            current.next =prev;
            prev= current;
            current = nextNode;
        }
        return prev;
    }
}

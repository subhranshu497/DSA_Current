package com.prep;

public class InsertGreatestCommonDivisorsInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        ListNode result = insertGreatestCommonDivisors(head);

        //print the linked list
        while(result != null){
            System.out.print(result.val +"-->");
            result = result.next;
        }
    }

    private static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        while(currNode !=null && nextNode !=null){
            int gcd=gcdLinkedList(currNode.val, nextNode.val);
            ListNode gcdNode =new ListNode(gcd);;
            currNode.next = gcdNode;
            gcdNode.next = nextNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        return head;
    }

    private static int gcdLinkedList(int a, int b) {
        if(b==0) return a;
        return gcdLinkedList(b, a%b);
    }
}

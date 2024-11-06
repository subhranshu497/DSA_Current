package com.prep.linkedlist;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode result = addTwoNum1(node1, node2);

        while(result != null){
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }

    private static ListNode addTwoNum1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry =0;
        while(l1 != null || l2 !=null || carry !=0){
            int val1 = l1 !=null ? l1.val:0;
            int val2 = l2 !=null ? l2.val:0;
            int sum = val1+val2+carry;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
            result = result.next;
        }
        return temp.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(ListNode next, int val){
            this.next = next;
            this.val = val;
        }
    }
}

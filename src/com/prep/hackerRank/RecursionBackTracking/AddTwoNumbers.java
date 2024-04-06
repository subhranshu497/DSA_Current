package com.prep.hackerRank.RecursionBackTracking;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);

        while(result !=null){
            System.out.print(result.val+", ");
            result = result.next;
        }

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry =0;
        while(l1 !=null || l2 !=null || carry !=0){
            int x = (l1 !=null)?l1.val:0;
            int y = (l2 !=null)?l2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            curr.next = new ListNode(sum %10);
            curr = curr.next;
            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
        }
        return result.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next= next;
    }
}

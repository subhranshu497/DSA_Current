package com.prep;

import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNum(l1, l2);
    }

    private static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry =0;
        while(l1 !=null || l2 !=null || carry !=0){
            int num1 = (l1 !=null)?l1.val:0;
            int num2 = (l2 !=null)?l2.val:0;
            int sum = num1+num2+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr =curr.next;
            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
        }
        return result.next;
    }
}

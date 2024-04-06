package com.prep;

import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int n=2;
        ListNode node = new ListNode(1);
        ListNode result = removeKth(node,n);
    }

    private static ListNode removeKth(ListNode node, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode fast =dummy;
        ListNode slow = dummy;
        for(int i=0;i<=n;i++){
            fast = fast.next;
        }
        while(fast !=null){
            fast =fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val =val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

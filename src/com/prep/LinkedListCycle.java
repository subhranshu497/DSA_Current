package com.prep;

//Leetcode #141
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow =head;
        ListNode fast =head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)return true;
        }
        return false;
    }
}

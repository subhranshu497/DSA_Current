package com.prep.hackerRank.RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class PallindromeLinkedList {
    static ListNode first;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalli(head));

    }
    private static boolean pallindromeLinkedListTwopointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseLL(slow.next);
        ListNode first = head;
        while(second.next !=null){
            if(second.val !=first.val){
                ListNode revSecocnd = reverseLL(second);
                return false;
            }
            second = second.next;
            first = first.next;
        }
        ListNode revSecocnd2 = reverseLL(second);
        return true;
    }

    private static ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newNode = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return  newNode;
    }


    private static boolean isPalliRecursion(ListNode head){
        first = head;
        return checkPalliRec(head);
    }

    private static boolean checkPalliRec(ListNode curr) {
        if(curr !=null){
            if(!checkPalliRec(curr.next)) return false;
            if(curr.val != first.val) return false;
            first = first.next;
        }
       return true;
    }

    private static boolean isPalli(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode !=null){
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int left =0;
        int right=list.size()-1;
        while (left < right){
            if(list.get(left) !=list.get(right))return false;
            left++;
            right--;
        }
        return true;
    }


}

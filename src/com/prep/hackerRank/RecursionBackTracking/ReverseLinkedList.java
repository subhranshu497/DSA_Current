package com.prep.hackerRank.RecursionBackTracking;


import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);
        ListNode result = reverseNodeRecursion(list1);
        while (result !=null){
            System.out.print(result.val+", ");
            result = result.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if(head ==null || head.next == null)return head;
        ListNode prevNode = null;
        ListNode currentNode = head;
        while(currentNode !=null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
        return head;
    }
    private static ListNode reverseNodeRecursion(ListNode head){
        if(head==null) return head;
        if(head.next==null)return head;
        ListNode newNode = reverseNodeRecursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next =null;
        return newNode;
    }
}


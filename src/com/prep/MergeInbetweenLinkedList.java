package com.prep;

public class MergeInbetweenLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);
        ListNode list2 = new ListNode(100);
        list2.next = new ListNode(101);
        list2.next.next = new ListNode(102);

        int a = 3;
        int b = 4;
        ListNode result = mergeLinkedList(list1, list2, a,b);
        while (result !=null){
            System.out.print(result.val+", ");
            result = result.next;
        }
    }

    private static ListNode mergeLinkedList(ListNode list1, ListNode list2, int a, int b) {
        ListNode mergeStart = null;
        ListNode mergeEnd = list1;
        for(int index =0;index<b;index++){
            if(index == a-1) mergeStart = mergeEnd;
            mergeEnd = mergeEnd.next;
        }
        mergeStart.next = list2;
        while(list2.next !=null){
            list2 = list2.next;
        }
        list2.next = mergeEnd.next;
        mergeEnd.next =null;
        return list1;
    }
}

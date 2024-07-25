package com.prep;

public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        ListNode1 node = new ListNode1(5);
        deleteNode1(node);
    }
//4--->5--->1---->9 node =5
    private static void deleteNode1(ListNode1 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    public ListNode1(int val, ListNode1 next){
        this.val = val;
        this.next = next;
    }
    public ListNode1(int val){
        this.val = val;
    }
    public ListNode1(){}
}

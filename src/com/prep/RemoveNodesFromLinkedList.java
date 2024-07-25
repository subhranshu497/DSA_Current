package com.prep;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(5);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(13);
        head.next.next.next = new ListNode1(3);
        head.next.next.next.next = new ListNode1(8);
        ListNode1 result = removeNodes(head);
        //printing the linked list
        while(result !=null){
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }

    public static ListNode1 revreseTheList(ListNode1 head){
        ListNode1 prev = null;
        ListNode1 next = null;
        ListNode1 current = head;
        while (current !=null){
            next = current.next;
            current.next =prev;
            prev =current;
            current =next;
        }
        head =prev;
        return head;
    }

    private static ListNode1 removeNodes(ListNode1 head) {
        if(head == null) return head;
        int max = 0;
        head = revreseTheList(head);
        ListNode1 left = null;
        ListNode1 right = head;
        while(right !=null){
            Math.max(max, right.val);
            if(right.val<max){
                left.next = right.next;
                ListNode1 deleted = right;
                right = right.next;
                deleted.next = null;
            }
            else{
                left = right;
                right = right.next;
            }
        }

        return revreseTheList(head);
    }
}

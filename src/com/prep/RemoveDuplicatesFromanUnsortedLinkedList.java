package com.prep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesFromanUnsortedLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        ListNode result = deleteDuplicatesUnsorted(head);
    }

    private static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode node = head;
        while(node !=null){
            int val = node.val;
            map.put(val, map.getOrDefault(val,0)+1);
            node = node.next;
        }
        for(int key: map.keySet()){
            int val = map.get(key);
            if(val ==1){
                result.next = new ListNode(key);
                result = result.next;
            }
        }
        return curr.next;
    }
}

package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LinkedListFrequency {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        ListNode result = frequenciesOfElements(head);
    }

    private static ListNode frequenciesOfElements(ListNode head) {
        ListNode curr = head;
        ListNode result = null;
        Map<Integer, ListNode> freq = new HashMap<>();
        while(curr !=null){
            if(freq.containsKey(curr.val)){
                ListNode newList = freq.get(curr.val);
                newList.val +=1;
            }
            else{
                ListNode newFrequencyNode = new ListNode(1, result);
                freq.put(curr.val, newFrequencyNode);
                result = newFrequencyNode;
            }
            curr = curr.next;
        }
        return result;
    }
}

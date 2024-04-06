package com.prep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode result = removeZeroSumSublists(head);
    }

    private static ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next =head;

        map.put(0,dummyNode);
        int prefixSum=0;
        while(head !=null){
            prefixSum += head.val;
            if(map.containsKey(prefixSum)) {
                ListNode start =map.get(prefixSum);
                ListNode temp = start;
                int pSum = prefixSum;
                while(temp !=head){
                    temp = temp.next;
                    pSum += temp.val;
                    if(temp !=head)map.remove(pSum);
                }
            }
            else{
                map.put(prefixSum,head);
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}

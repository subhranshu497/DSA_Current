package com.prep;

public class SplitLinkedListinParts {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        int k =5;
        ListNode [] result = splitListToParts(head, k);
    }

    private static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        //calculate size of head
        int size =0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        int resultLLSize = size/k;
        int rem = size %k;
        // form the result list
        ListNode [] ans = new ListNode[k];
        ListNode prev = null;
        curr = head;
        for(int i =0;i<k && curr !=null;i++, rem--){
            ans[i] = curr;
            for(int j=0; j< resultLLSize+(rem>0?1:0);j++){
                prev = curr;
                curr = curr.next;
            }
            if(prev != null){
                prev.next=null;
            }
        }
        return ans;
    }
}

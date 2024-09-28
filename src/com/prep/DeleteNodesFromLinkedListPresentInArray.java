package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        ListNode2 result = modifiedList(nums, head);
        //to print the list
        while(result !=null){
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }

    private static ListNode2 modifiedList(int[] nums, ListNode2 head) {
        Set<Integer> set = new HashSet<>();
        ListNode2 result = new ListNode2();
        ListNode2 finalResult = result;
        for(int num:nums){
            set.add(num);
        }
        System.out.println(set);
        List<Integer> list = new ArrayList<>();
        while(head !=null){
            if(!set.contains(head.val)) {
                result.next = new ListNode2(head.val);
                result = result.next;
                //list.add(head.val);
            }
            head = head.next;
        }
        System.out.println(list);
//        int i=0;
//        while(i<list.size()){
//            result.next = new ListNode2(list.get(i));
//            result = result.next;
//            i++;
//        }
        return finalResult.next;
    }
}
class ListNode2{
    int val;
    ListNode2 next;

    ListNode2(){}
    ListNode2(int val){
        this.val = val;
    }
    ListNode2(int val, ListNode2 next){
        this.val = val;
        this.next = next;
    }
}


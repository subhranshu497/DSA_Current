package com.prep;

public class WinneroftheLinkedListGame {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next =new ListNode(1);
        System.out.println(gameResult(head));
    }

    private static String gameResult(ListNode head) {
        int even =0;
        int odd=0;
        while(head !=null && head.next !=null){
            if(head.val >head.next.val) even++;
            else odd++;

            head =head.next.next;
        }
        if(even>odd) return "Even";
        else if(odd>even) return "Odd";
        else return "Tie";
    }
}

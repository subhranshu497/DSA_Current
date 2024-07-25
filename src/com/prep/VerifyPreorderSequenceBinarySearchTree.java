package com.prep;

import java.util.Iterator;
import java.util.Stack;

public class VerifyPreorderSequenceBinarySearchTree {
    public static void main(String[] args) {
        int [] preOrder = {5,2,3,1,6};
        System.out.println(verifyPreOrder(preOrder));
    }

    /**
     *st = 5
     * @param preOrder
     * @return
     */
    private static boolean verifyPreOrder(int[] preOrder) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i< preOrder.length;i++){
            while(!st.isEmpty()&& preOrder[i]>st.peek()){
                root = st.peek();
                st.pop();
            }
            if(preOrder[i]<root) return false;
            st.push(preOrder[i]);
        }
        return true;
    }
}

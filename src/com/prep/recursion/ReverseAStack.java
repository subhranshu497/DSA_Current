package com.prep.recursion;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
//        System.out.println("Print Stack as is");
//        while (!st.isEmpty()){
//            System.out.print(st.pop()+" ");
//        }
        System.out.println();
        reverseStackUsingrecursion(st);
        // print the stack
        System.out.println("Reverse Stack");
        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println("End of code");
    }
    //TC = O(N) SC = O(N)

    private static void reverseStackUsingrecursion(Stack<Integer> st) {
        //Stack<Integer> temp = new Stack<>();
        solveReverseStackOptimized(st);
        //return temp;
    }

    private static void solveReverseStack(Stack<Integer> st, Stack<Integer> temp) {
        // base condition
        if(st.empty())return;
        int top = st.pop();
        temp.push(top);
        solveReverseStack(st, temp);
    }

    //this code is for TC= o(N^2) and SC = O(1)
    private static Stack<Integer> reverseStackUsingrecursionOptimized(Stack<Integer> st) {
        solveReverseStackOptimized(st);
        return st;
    }

    private static void solveReverseStackOptimized(Stack<Integer> st) {
        // base condition
        if(st.isEmpty()) return;

        int top = st.pop();
        solveReverseStackOptimized(st);
        //insert at the bottom
        insertAnElementBottomOfStack(st, top);

    }

    private static void insertAnElementBottomOfStack(Stack<Integer> st, int element) {
        //base condition
        if(st.isEmpty()){
            st.push(element);
            return;
        }
        int top = st.pop();
        insertAnElementBottomOfStack(st, element);
        st.push(top);
    }
}

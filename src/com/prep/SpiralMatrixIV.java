package com.prep;

import java.util.Arrays;

public class SpiralMatrixIV {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        int m =3;
        int n=5;
        int [][] result = spiralMatrixFour(head, m,n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] spiralMatrixFour(ListNode head, int m, int n) {
        int [][] result4 = new int[m][];
        for(int i=0;i<m;i++){
            result4[i] = new int[n];
            Arrays.fill(result4[i], -1);
        }
        int topRow = 0;
        int bottomRow = m-1;
        int leftCol =0;
        int rightCol = n-1;
        while(head !=null){
            for(int c=leftCol;c<=rightCol && head !=null;c++){
                result4[topRow][c] = head.val;
                head = head.next;
            }
            topRow++;
            for(int r=topRow;r<=bottomRow && head !=null;r++){
                result4[r][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;
            for(int c=rightCol;c>=leftCol && head !=null;c--){
                result4[bottomRow][c] = head.val;
                head = head.next;
            }
            bottomRow--;
            for(int r=bottomRow;r>=topRow && head !=null;r--){
                result4[bottomRow][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }
        return result4;
    }
}

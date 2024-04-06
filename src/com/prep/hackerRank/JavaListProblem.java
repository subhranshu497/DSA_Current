package com.prep.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaListProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<n;i++){
            int item = in.nextInt();
            list.add(item);
        }
        int q = in.nextInt();
        for(int i=0;i<q;i++){
            String query = in.next();
            if(query.equals("Insert")){
                int x = in.nextInt();
                int y = in.nextInt();
                list.add(x,y);
            }else{
                int x = in.nextInt();
                list.remove(x);
            }
        }
        for(int num:list){
            System.out.print(num+" ");
        }
    }
}

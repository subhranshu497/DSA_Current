package com.prep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class CustomStack {
    private List<Integer> stack;
    int maxSize;
    List<Integer> inc;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayList<>();
        inc = new ArrayList<>();
    }
    public void push(int x) {
        if(stack.size()<maxSize){
            stack.add(x);
            inc.add(0); // no increment
        }
    }

    public int pop() {
        if(!stack.isEmpty()){
            int idx = stack.size()-1;
            if(idx >0){
                inc.set(idx-1, inc.get(idx-1)+inc.get(idx));
            }
            int item = stack.get(idx)+inc.get(idx);
            stack.remove(idx);
            inc.remove(idx);
            return item;
        }
        return -1;
    }

    public void increment(int k, int val) {
        //o(1) - k val can be stack size
        int index = Math.min(k, stack.size())-1;
        if(index>=0)inc.set(index, inc.get(index)+val);
    }
}


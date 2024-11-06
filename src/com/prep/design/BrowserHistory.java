package com.prep.design;

import java.util.Stack;

public class BrowserHistory {
    private String curr;
    private Stack<String> back;
    private Stack<String> front;
    public BrowserHistory(String homepage) {
        curr = homepage;
        this.back = new Stack<>();
        this.front = new Stack<>();
    }

    public void visit(String url) {
        back.push(curr);
        curr = url;
        front = new Stack<>();
    }

    public String back(int steps) {
        while(!back.isEmpty() && steps !=0){
            front.push(curr);
            curr = back.pop();
            steps--;
        }
        return curr;
    }

    public String forward(int steps) {
        while(!front.isEmpty() && steps !=0){
            back.push(curr);
            curr = front.pop();
            steps--;
        }
        return curr;
    }
}

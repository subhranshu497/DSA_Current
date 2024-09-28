package com.prep;

public class TwoKeysKeyboard {
    public static void main(String[] args) {
        int n=10;
        int ans = keysKeyBoard(n);
        System.out.println(ans);
    }

    private static int keysKeyBoard(int n) {
        int ans =0;
        for(int i=2;i*i <=n;i++){
            while(n%i==0){
                ans +=i;
                n /=i;
            }
        }
        if(n>1) ans +=n;
        return ans;
    }
}

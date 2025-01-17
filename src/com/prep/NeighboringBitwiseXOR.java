package com.prep;

public class NeighboringBitwiseXOR {
    public static void main(String[] args) {
        int [] derived = {1,1,0};
        System.out.println(doesValidArrayExist(derived));
    }

    //use property of association of xor
    // if, a ^ b = c
    // a ^ a ^ b = c ^ a
    // b = c ^ a
    // a ^ c = b
    //also same is applicable while we do b^ on both side , b ^ c = a
    private static boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int original [] = new int[n];
        original[0] =1;
        for(int i=0;i < n-1 ;i++){
            original[i+1] = derived[i] ^ original[i];
        }
        if((derived[n-1] ^ original[n-1])==original[0]){
            return true;
        }
        original[0] =0;
        for(int i=0;i < n-1 ;i++){
            original[i+1] = derived[i] ^ original[i];
        }
        if((derived[n-1] ^ original[n-1])==original[0]){
            return true;
        }
        return false;
    }
}

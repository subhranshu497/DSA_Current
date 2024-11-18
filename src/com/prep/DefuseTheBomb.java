package com.prep;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int [] code = {5,7,1,4};
        int k =3;
        int [] ans = decrypt1(code, k);
        for(int num: ans)
            System.out.println(num);
    }

    private static int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int [] ans = new int[n];
        if(k==0)
            return ans;
        int i=0;
        int j=1;
        int count =0;
        if(k >0){
            while(i<n){
                int tempSum =0;
                while(count < k){
                    if(j==n) j = 0;
                    tempSum +=code[j];
                    j++;
                    count++;
                }
                ans[i] = tempSum;
                i++;
            }
        }
        else if(k < 0){
            while(i < n){
                int tempSum =0;
                while(count > k){
                    tempSum += code[n-1-count];
                    count--;
                }
                ans[i] = tempSum;
                i++;
            }
        }
        return ans;
    }
}

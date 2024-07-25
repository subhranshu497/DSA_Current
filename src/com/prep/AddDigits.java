package com.prep;

public class AddDigits {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDig(num));
    }

    private static int addDig(int num) {
        int result = 0;
        while(num >0){
            result +=num%10; //0+8
            num /=10; // 3
            if(num==0 && result >9){
                num =result;
                result =0;
            }
        }
        return result;
    }

    /**
     * 38 %10 =8
     *
     * @param s
     * @param num
     * @param result
     */
    private static void calculate(String s, int num, int result) {

    }
}

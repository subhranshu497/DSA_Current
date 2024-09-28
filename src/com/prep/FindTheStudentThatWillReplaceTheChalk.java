package com.prep;

public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        int [] chalk = {5,1,5};
        int k =22;
        int student= chalkReplacer(chalk, k);
        System.out.println(student);
    }

    private static int chalkReplacer(int[] chalk, int k) {
        int n =chalk.length;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(k < chalk[i]) return i;
            k -=chalk[i];
            if(i == n-1){
                i=-1;
                continue;
            }
        }
        return Integer.MAX_VALUE;
    }
}

package com.prep;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1,version2));
    }

    private static int compareVersion(String version1, String version2) {
        String[] strArr1 = version1.split("\\.");
        String[] strArr2 = version2.split("\\.");
        int n1 = strArr1.length;
        int n2 = strArr2.length;
        int i1=0;
        int i2=0;
        for(int i=0;i<Math.max(n1,n2);i++){
            i1 = i <n1 ? Integer.parseInt(strArr1[i]):0;
            i2 = i <n2 ? Integer.parseInt(strArr2[i]):0;
            if(i1 != i2) return i1>i2?1:-1;
        }
        return 0;
    }

}

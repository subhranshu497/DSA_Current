package com.prep;

public class SentenceSimilarityIII {
    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    private static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String [] s1Arr = sentence1.split("\\s");
        String [] s2Arr = sentence2.split("\\s");
        int n1 = s1Arr.length;
        int n2 = s2Arr.length;
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < n1 && ptr2 <n2){
            String str1 = s1Arr[ptr1];
            String str2 = s2Arr[ptr2];
            if(str1.equals(str2)){
                ptr1++;
                ptr2++;
            }
            else{
                ptr2++;
            }
        }
        return ptr2==n2?true:false;
    }
}

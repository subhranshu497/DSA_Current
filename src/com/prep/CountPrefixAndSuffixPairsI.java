package com.prep;

public class CountPrefixAndSuffixPairsI {
    public static void main(String[] args) {
        String [] words ={"abab","ab"};
        int pairs = countPrefixSuffixPairs(words);
        System.out.println(pairs);
    }

    private static int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int pairs =0;
        for(int i=0;i<n;i++){
            String preSuf = words[i];
            for(int j=i;j<n;j++){
                String word = words[j];
                if(i==j)continue;
                if(preSuf.length()<=word.length()){
                    if(word.startsWith(preSuf)&& word.endsWith(preSuf))
                        pairs++;
                }
            }
        }
        return pairs;
    }
}

package com.prep.trie;

import java.util.List;

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        isEnd =false;
        children = new TrieNode[26];
    }
}
class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            if(current.children[c-'a']==null)current.children[c-'a']=new TrieNode();
            current = current.children[c-'a'];
        }
        current.isEnd=true;
    }
    public String shortestPath(String s) {
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(curr.children[c-'a']==null) return s;
            curr = curr.children[c-'a'];
            if(curr.isEnd) return s.substring(0,i+1);
        }
        return s;
    }
}
public class ReplaceWords {
    public static void main(String[] args) {
        String sentence = "the cattle was rattled by the battery";
        List<String> dictionary = List.of("cat","bat","rat");
        String result = replaceWordsTrie(dictionary, sentence);
        System.out.println(result);
    }

    private static String replaceWordsTrie(List<String> dictionary, String sentence) {
        String wordArr[] =sentence.split(" ");
        Trie dictTrie = new Trie();
        for(String word:dictionary){
            dictTrie.insert(word);
        }
        for(int i=0;i<wordArr.length;i++){
            wordArr[i] = dictTrie.shortestPath(wordArr[i]);
        }
        return String.join(" ",wordArr);
    }
}

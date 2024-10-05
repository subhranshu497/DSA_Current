package com.prep.trie;

public class Trie {
    // declare a root node
    //every node has 26 children and endofword marker
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    //can insert character by character
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode());
            }
            node =node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i)))return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
//shortest path is the junk method . ignore it in this code
    public String shortestPath(String s) {
        return "";
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
        TrieNode(){}
        private boolean containsKey(char ch){
            return children[ch-'a'] !=null;
        }
        private void put(char ch , TrieNode node){
            children[ch-'a'] = node;
        }

        public TrieNode get(char c) {
            return children[c-'a'];
        }

        public void setEnd() {
            isEndOfWord= true;
        }

        public boolean isEnd() {
            return isEndOfWord;
        }
    }
}
class Solution{
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        boolean flag = t.search("apple");
        System.out.println(flag);
    }
}


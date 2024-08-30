package TrieTemplate;

import java.util.Arrays;

public class TriesAC {
    public static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26];
            Arrays.fill(children,null);
        }
    }
    public static Node root;
    public TriesAC(){
        root = new Node();
    }
    public static void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx]==null){
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.endOfWord=true;
    }

    public static boolean search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx]==null){
                return false;
            }
            node = node.children[idx];
        }
        return node.endOfWord;
    }
    public static boolean searchPrefix(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root){
        if(root == null) return 0;
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }
//    public static void main(String[] args) {
//        TrieTemplate.TriesAC triesAC = new TrieTemplate.TriesAC();
//        triesAC.insert("there");
//        System.out.println(triesAC.search("there")); // Should print true
//        System.out.println(triesAC.searchPrefix("the")); // Should print false
//    }

}

package com.Ritesh.Strings;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//        permutation("", "abc");
//        ArrayList<String> ans = permutationsList("", "abcd");
//        System.out.println(ans);
        System.out.println(permutationsCount("", "abcd"));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0, i);
            String f = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1));
        }
    }
    static ArrayList<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0, i);
            String f = p.substring(i, p.length());
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }
    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String s = p.substring(0, i);
            String f = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}

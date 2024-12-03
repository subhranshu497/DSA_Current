package com.prep;

public class AddingSpacesToAString {
    public static void main(String[] args) {
        String s ="LeetcodeHelpsMeLearn";
        int [] spaces = {8,13,15};
        String str = addSpaces(s, spaces);
        System.out.println(str);
    }

    private static String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int spacesLen = spaces.length;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, spaces[0]));
        int i=1;
        for(;i<spacesLen;i++){
            sb.append(" ");
            sb.append(s.substring(spaces[i-1], spaces[i]));
        }
        sb.append(" ");
        sb.append(s.substring(spaces[i-1]));
        return sb.toString();
    }
}

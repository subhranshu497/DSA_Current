import java.util.LinkedHashMap;
import java.util.Map;

public class AppendCharactersToStringMakeSubsequence {
    public static void main(String[] args) {
        String s="abcde";
        String t = "a";
        int noOfChar = appendChar(s,t);
        System.out.println(noOfChar);
    }

    private static int appendChar(String s, String t) {
        int first =0;
        int longest =0;
        while(first<s.length() && longest<t.length()){
            if(s.charAt(first)== t.charAt(longest))longest++;
            first++;
        }
        return t.length() - longest;
    }
}

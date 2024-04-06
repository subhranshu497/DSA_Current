package com.prep;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isoMorphic(s,t));
    }

    private static boolean isoMorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Create a hashmap to store character mappings
        Map<Character, Character> charMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!charMappingMap.containsKey(original)) {
                if (!charMappingMap.containsValue(replacement))
                    charMappingMap.put(original, replacement);
                else
                    return false;
            }
            else {
                char mappedCharacter = charMappingMap.get(original);
                if (mappedCharacter != replacement)
                    return false;
            }
        }
        return true;
    }
}

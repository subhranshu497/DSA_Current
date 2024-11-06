package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        String [] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> result = removeSubfolders(folder);
        System.out.println(result);
    }

    private static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for(String s:folder){
            if(result.isEmpty() || !s.startsWith(result.get(result.size()-1)+"/")){
                result.add(s);
            }
        }
        return result;
    }
}

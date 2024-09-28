package com.prep;

import java.util.*;

public class FindSmallestRegion {
    public static void main(String[] args) {
        List<List<String>> regions = new ArrayList<>();
        regions.add(Arrays.asList("Earth", "North America", "South America"));
        regions.add(Arrays.asList("North America", "United States", "Canada"));
        regions.add(Arrays.asList("United States", "New York", "Boston"));
        regions.add(Arrays.asList("Canada", "Ontario", "Quebec"));
        regions.add(Arrays.asList("South America", "Brazil"));
        String region1 = "Quebec";
    String region2 = "New York";
    String result = findSmallestRegion(regions, region1, region2);
        System.out.println(result);
    }

    private static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        //build the adj list
        Map<String, String> parentMap = new HashMap<>();
        for(List<String> region:regions){
            String parent = region.get(0);
            for(String child:region){
                if(child.equals(parent))continue;
                parentMap.put(child, parent);
            }
        }
        System.out.println(parentMap);
        Set<String> parentRegion1Set = new HashSet<>();
        while(region1 !=null){
            parentRegion1Set.add(region1);
            region1 = parentMap.get(region1);
        }
        while(region2 !=null){
            if(parentRegion1Set.contains(region2))return region2;
            region2 = parentMap.get(region2);
        }
        return null;
    }
}

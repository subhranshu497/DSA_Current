public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding(heights,bricks,ladders));
    }

    private static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int index = 0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[i-1]){
                int diff = heights[i]-heights[i-1];
                if(diff >=bricks && ladders !=0){
                    ladders--;
                    continue;
                }
                else if(bricks>=diff && bricks !=0) bricks = bricks-diff;
                else {
                    return i-1;
                }
            }
        }
        return index;
    }
}

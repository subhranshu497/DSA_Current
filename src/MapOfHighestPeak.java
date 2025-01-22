import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    public static void main(String[] args) {
        int [][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int [][] result = highestPeak(isWater);
        for(int i=0;i < result.length;i++){
            for(int j=0;j < result[0].length;j++){
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int [][] result = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int [] arr:result)
            Arrays.fill(arr, -1);
        // first fill all the cells having water with 0 in the result matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    result[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        //lets start a multi source bfs
        while(!q.isEmpty()){
            int [] current = q.poll();
            int x = current[0];
            int y = current[1];
            for(int [] direction:directions){
                int x_ = x+direction[0];
                int y_ = y+direction[1];
                if(isValid(x_,y_,m,n) && result[x_][y_]==-1){
                    result[x_][y_] =result[x][y]+1;
                    q.add(new int[]{x_, y_});
                }
            }
        }
        return result;
    }
    private static boolean isValid(int i, int j, int m, int n){
        return i<m && i>=0 && j<n && j>=0;
    }
}

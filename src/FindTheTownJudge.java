import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][] trust ={{1,3},{2,3},{3,1}};
        int n=3;
        System.out.println(townJudge(trust,n));
    }

    private static int townJudge(int[][] trust, int n) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for(int[] arr:trust){
            outDegree[arr[0]]++;
            inDegree[arr[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(outDegree[i]==0 && inDegree[i]==n-1) return i;
        }
        return -1;
    }
}

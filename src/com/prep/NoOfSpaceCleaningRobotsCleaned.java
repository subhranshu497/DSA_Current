package com.prep;

public class NoOfSpaceCleaningRobotsCleaned {
    private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };
    public static void main(String[] args) {
        int[][] rooms = {{0,0,0},{1,1,0},{0,0,0}};
        int steps = numberOfCleanRooms(rooms);
        System.out.println(steps);
    }

    private static int numberOfCleanRooms(int[][] rooms) {
        int steps=0;
        int i=0;
        int j=0;
        int m=rooms.length;
        int n=rooms[0].length;
        int direction =0;
        while(((rooms[i][j] >>(direction+1))&1)==0){
            if(rooms[i][j]==0)steps++;
            rooms[i][j] |= 1 << (direction+1);
            int nextRow = i + DIRECTIONS[direction];
            int nextCol = j + DIRECTIONS[direction + 1];
            if (0 <= nextRow && nextRow < i && 0 <= nextCol && nextCol < j && rooms[nextRow][nextCol] != 1) {
                i = nextRow;
                j = nextCol;
            } else {
                direction = (direction + 1) % 4;
            }
        }
        return steps;
    }
}

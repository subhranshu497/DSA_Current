package com.prep;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int [] students = {1,1,0,0};
        int [] sandwiches = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }

    private static int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCounts = 0;
        int sqrStCount =0;
        for(int st:students){
            if(st==0)circleStudentCounts++;
            else sqrStCount++;
        }
        for(int sandwich:sandwiches){
            if(sandwich==0 && circleStudentCounts==0) return sqrStCount;
            if(sandwich==1 && sqrStCount==0) return circleStudentCounts;
            if(sandwich==0)circleStudentCounts--;
            if(sandwich==1)sqrStCount--;
        }
        return 0;
    }
}

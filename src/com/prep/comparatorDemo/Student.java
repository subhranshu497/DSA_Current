package com.prep.comparatorDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private int score;
    private String name;
    private int rollno;

    public Student(){}
    public Student(int score, String name, int rollno) {
        this.score = score;
        this.name = name;
        this.rollno = rollno;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", rollno=" + rollno +
                '}';
    }
}
class Solution{
    public static void main(String[] args) {
        Student s1 = new Student(90,"Kiana",1);
        Student s2 = new Student(30,"Aarya",5);
        Student s3 = new Student(50,"Shayansh",3);
        Student s4 = new Student(70,"Nainika",2);
        Student s5 = new Student(30,"Leo",4);

        List<Student> stList = new ArrayList<>();
        stList.add(s1);
        stList.add(s2);
        stList.add(s3);
        stList.add(s4);
        stList.add(s5);
        //sort the student list based on the score in descending order.
        // If two students have same score sort them based on their name in alphabetical order
        List<Student> sortedList = sortStudent(stList);
    }

    private static List<Student> sortStudent(List<Student> stList) {
        Collections.sort(stList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s2.getScore()<s1.getScore()){
                    return 1;
                }
                else if(s2.getScore()>s1.getScore()){
                    return -1;
                }
                else{
                    return s1.getName().compareTo(s2.getName());
                }
            }
        });
        System.out.println("Student List Post Sorting" +stList);
        return stList;
    }
}

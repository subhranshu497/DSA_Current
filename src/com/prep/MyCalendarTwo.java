package com.prep;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    //take two list of pair , one to store overall booking the other one for double booking
    //if the the incoming pair collide with the interval mentioned in doublebooking, then its an option for triple booking , hence return false
    List<Pair> bookings ;
    List<Pair> doubleBookings;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // check for Triplebooking
        for(Pair region :doubleBookings){
            if(checkForOverLap(region.first, region.second, start, end)) return false;
        }
        //check for doublebooking
        for(Pair booking:bookings){
            if(checkForOverLap(booking.first, booking.second, start, end)){
                doubleBookings.add(findDoubleBookingRegion(booking.first,booking.second, start, end));
            }
        }
        bookings.add(new Pair(start, end));
        return true;
    }

    private Pair findDoubleBookingRegion(int start1, int end1, int start2, int end2) {
        return new Pair(Math.max(start1, start2), Math.min(end1, end2));
    }

    private boolean checkForOverLap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    class Pair{
        int first;
        int second;
        public Pair(){}
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}

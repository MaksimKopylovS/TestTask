package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightsList = FlightBuilder.createFlights();
        System.out.println("    *** Start ***");
        //Initial list
        flightsList.forEach(System.out::println);
        System.out.println("    *** End *** \n");

        System.out.println("    *** Task one ***");
        //The task, is one flight up to the current point in time.
        new FilterFlightUpToTheCurrentPointInTime().filter(flightsList).forEach(System.out::println);
        System.out.println("    *** End *** \n");

        System.out.println("    *** Task two ***");
        //Task two, there are segments with an arrival date earlier than the departure date.
        new FilterArrivalDateBeforeDepartureDate().filter(flightsList).forEach(System.out::println);
        System.out.println("    *** End *** \n");

        System.out.println("    *** Task three ***");
        //Task three, total time spent on the ground exceeds two hours
        new FilterTimeSpentOnEarthExceedsTwoHours().filter(flightsList).forEach(System.out::println);
        System.out.println("    *** End *** \n");
    }
}

package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterTimeSpentOnEarthExceedsTwoHours implements FilterFlight {
    @Override
    public List<Flight> filter(List<Flight> flightList) {

        List<Segment> segmentList = new ArrayList<>();
        List<Flight> flightListFilter = new ArrayList<>();
        //Variable to save the previous segment
        Segment saveSegment = null;

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                //The check will be performed if there is more than one segment in the list of segments
                if (saveSegment != null) {
                    //If the total time spent on the ground is more than two hours, that segment will not be included in the list.
                    if (!saveSegment.getArrivalDate().plusMinutes(120).isBefore(segment.getDepartureDate())) {
                        segmentList.add(segment);
                    }

                } else {
                    segmentList.add(segment);
                    saveSegment = segment;
                }
            }
            //excludes null segments from the list
            if (segmentList.size() != 0) {
                flightListFilter.add(new Flight(segmentList));
            }
            saveSegment = null;
            segmentList = new ArrayList<>();
        }
        return flightListFilter;
    }
}

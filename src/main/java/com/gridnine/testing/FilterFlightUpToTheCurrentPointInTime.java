package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class FilterFlightUpToTheCurrentPointInTime implements FilterFlight {

    @Override
    public List<Flight> filter(List<Flight> flightList) {

        LocalDateTime threeDaysFromNow = LocalDateTime.now();

        List<Segment> segmentList = new ArrayList<>();
        List<Flight> flightListFilter = new ArrayList<>();

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                //if the departure time is before the current time, this segment will not be included in the list
                if(!segment.getDepartureDate().isBefore(threeDaysFromNow)){
                    segmentList.add(segment);
                }
            }
            //excludes null segments from the list
            if (segmentList.size() != 0) {
                flightListFilter.add(new Flight(segmentList));
            }
            segmentList = new ArrayList<>();
        }
        return flightListFilter;
    }

}
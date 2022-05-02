package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterArrivalDateBeforeDepartureDate implements FilterFlight  {
    @Override
    public List<Flight> filter(List<Flight> flightList) {

        List<Segment> segmentList = new ArrayList<>();
        List<Flight> flightListFilter = new ArrayList<>();

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                //If the arrival date is earlier than the departure date, this segment will not be included in the list
                if(!segment.getArrivalDate().isBefore(segment.getDepartureDate())){
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

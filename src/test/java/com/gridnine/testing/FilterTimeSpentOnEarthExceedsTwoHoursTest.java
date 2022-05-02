package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterTimeSpentOnEarthExceedsTwoHoursTest {

    @Test
    void filter() {
        assertEquals(FlightBuilder.createFlights().get(5).getSegments().size() - 1,
                new FilterTimeSpentOnEarthExceedsTwoHours()
                        .filter(FlightBuilder.createFlights())
                        .get(5).getSegments().size());
    }
}
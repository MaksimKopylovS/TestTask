package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterFlightUpToTheCurrentPointInTimeTest {

    @Test
    void filter() {
        assertEquals(FlightBuilder.createFlights().size() - 1,
                new FilterFlightUpToTheCurrentPointInTime().filter(FlightBuilder.createFlights()).size());
    }

}
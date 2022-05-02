package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FilterArrivalDateBeforeDepartureDateTest {


    @Test
    void filter() {
        assertEquals(FlightBuilder.createFlights().size() - 1,
                new FilterArrivalDateBeforeDepartureDate().filter(FlightBuilder.createFlights()).size());
    }

}
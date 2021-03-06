package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilteringTest {

    /**
     * The test demonstrates how to filter a stream using a predicate.
     */
    @Test
    public void shouldFilterWithPredicate() {
        List<Vehicle> vehicles = FleetFactory.get();

        List<Vehicle> dieselVehicles = vehicles.stream()
            .filter(v -> v.isDiesel())
            .collect(toList());

        assertThat(dieselVehicles.size(), is(6));
    }

    /**
     * The test demonstrates how to find distinct elements in a stream.
     */
    @Test
    public void shouldFilterEvenDistinctNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> distinctEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .distinct()
            .collect(toList());

        assertThat(distinctEven.size(), is(2));
    }

}

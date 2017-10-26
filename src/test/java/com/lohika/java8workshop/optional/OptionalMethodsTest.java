package com.lohika.java8workshop.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalMethodsTest {

    /**
     * The test demonstrates creating {@code Optional.of} with {@code null} value.
     */
    @Test(expected = NullPointerException.class)
    public void shouldShowNullPointerOnInitialization() {
        Optional<String> maybeString = Optional.of(null);
    }

    /**
     * The test demonstrates calling {@code Optional.get} on {@code Optional} with
     * absent value.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldShowNullPointerOnGet() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.get();
    }

    /**
     * The test demonstrates calling {@code Optional.orElseThrow} on {@code Optional} with
     * absent value and throwing different {@code Exception}.
     */
    @Test(expected = NullPointerException.class)
    public void shouldOrElseThrow() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.orElseThrow(NullPointerException::new);
    }

    /**
     * The test demonstrates calling {@code Optional.orElseGet} on {@code Optional} with
     * absent value.
     */
    @Test
    public void shouldOrElseGet() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.orElseGet(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "this took long to execute";
        });

        assertThat(value, is("this took long to execute"));
    }

    /**
     * The test demonstrates {@code Optional} filtering.
     */
    @Test
    public void shouldShowFilterUsage() {
        Insurance insurance = new Insurance("super-insurance");
        Optional<Insurance> maybeInsurance = Optional.of(insurance);

        maybeInsurance
            .filter(ins -> "super-insurance".equals(ins.getName()))
            .ifPresent(ins -> System.out.println("This is super-insurance"));
    }

    /**
     * The test demonstrates {@code Optional.orElse} usage with empty and
     * not empty {@code Optional}.
     */
    @Test
    public void shouldShowOrElseUsage() {
        Optional<String> maybeName = Optional.empty();
        assertThat(maybeName.orElse("else"), is("else"));

        maybeName = Optional.of("name");
        assertThat(maybeName.orElse("else"), is("name"));
    }

}

/*
 * Copyright (c) 2022.
 * Author: Iacopo Filiberto
 */

package it.filiberto;

public class Interval {
    private final Double lowerBound;
    private final Double upperBound;

    public Interval(Double lowerBound, Double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Double lowerBound() {
        return lowerBound;
    }

    public Double upperBound() {
        return upperBound;
    }

    public Double getWidth() {
        return upperBound - lowerBound;
    }

    @Override
    public String toString() {
        return String.format("[%f, %f): %f", lowerBound, upperBound, getWidth());
    }
}

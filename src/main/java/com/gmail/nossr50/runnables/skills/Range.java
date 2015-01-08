package com.gmail.nossr50.runnables.skills;

import java.util.Random;

public class Range {
    
    private double min, max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }
    
    public boolean isWithinInclusive(double value) {
        return value >= min && value <= max;
    }
    
    public boolean isWithinExclusive(double value) {
        return value > min && value < max;
    }
    
    public static Range toRange(double min, double max) {
        return new Range(min, max);
    }
    
    public static Range toRange(int min, int max) {
        return new Range(min, max);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(min);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(max);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    private static Random random = new Random();

    public double randomValue() {
        return random.nextInt((int) (max * 10) - (int) (min * 10)) / 100 + min;
    }
}

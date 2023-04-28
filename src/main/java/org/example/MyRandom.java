package org.example;


public class MyRandom {
    private final double a, c, m;
    private double s;

    public MyRandom(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public MyRandom s(long s) {
        this.s = s;
        return this;
    }

    public long next() {
        // x[n + 1] = 1 (a x[n] + c) % m
        return (long) ((a * s + c) % m);
    }


}

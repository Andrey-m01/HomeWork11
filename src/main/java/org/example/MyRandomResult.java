package org.example;

import java.util.stream.Stream;

public class MyRandomResult {
    public Stream<Long> myRandomStream(long a, long c, long m, long s) {
        MyRandom myRandom = new MyRandom(a, c, m);


        return Stream.iterate(s, (seed) -> myRandom.s(seed).next());
    }
}

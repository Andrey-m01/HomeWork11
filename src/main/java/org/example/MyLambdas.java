package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLambdas {

    public static String oddList(List<String> stringList) {
        AtomicInteger i = new AtomicInteger(1);
        List<String> result = stringList.stream()
                .map(s -> i.getAndIncrement() + ". " + s)
                .filter(s -> Integer.valueOf(s.substring(0, 3)
                        .replaceAll("[^0-9]", "")) % 2 == 1)
                .collect(Collectors.toList());
        return listToString(result);
    }

    public static String getUpperSortedNames(List<String> stringList) {
        List<String> result = stringList.stream()
                .map(s -> s.toUpperCase())
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
        return listToString(result);
    }

    public static String getSortedStringFromArray(Integer[][] numbers) {
        List<String> intermediate = (Arrays.stream(numbers)
                .flatMap(Arrays::stream)
                .sorted()
                .map(s -> String.valueOf(s))
                .collect(Collectors.toList()));
        return listToString(intermediate);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        ArrayList result = new ArrayList<>();
        Iterator firstIterator = first.iterator();
        Iterator secondIterator = second.iterator();

        while (firstIterator.hasNext() && secondIterator.hasNext()){
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }

        return result.stream();
    }

    private static String listToString(List stringList) {
        StringBuilder result = new StringBuilder();
        Iterator<String> stringIterator = stringList.iterator();
        while (stringIterator.hasNext()) {
            result.append(stringIterator.next());
            if (stringIterator.hasNext()) result.append(", ");
        }
        return result.toString();
    }


}

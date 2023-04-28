package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.MyLambdas.*;

public class Main {
    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("Ivan", "Peter", "Andrew", "Anna", "Elena", "Mikel", "Sergii");

        String task1 = oddList(nameList);
        System.out.println(" Task1\n" + task1 + "\n");

        String task2 = getUpperSortedNames(nameList);
        System.out.println(" Task2\n" + task2 + "\n");

        String task3 = getSortedStringFromArray(new Integer[][]{{1, 2, 0}, {4, 5}});
        System.out.println(" Task3\n" + task3 + "\n");

        System.out.println("Task4\n");
        MyRandomResult myRandomResult = new MyRandomResult();
        Stream<Long> resultSet = myRandomResult.myRandomStream(25214903917L, 11L, (long) 2e48d, 0L);
        resultSet.limit(10)
                .peek(System.out::println)
                .collect(Collectors.toSet());

        System.out.println("\n\n Task5\n");
        Stream<String> first = nameList.stream();
        Stream<String> second = Stream.of("i", "0", "1", "2", "3");
        zip(first, second).peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\n Job well done.\n\n  Bye.");
    }
}
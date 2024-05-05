package com.bnb.streamAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date joiningDateRam = dateFormat.parse("01-01-2000");
        Date joiningDateSita = dateFormat.parse("15-05-1995");
        Date joiningDateVishnu = dateFormat.parse("10-12-1998");
        Date joiningDateMahesh = dateFormat.parse("20-03-1990");

        List<Employee> emp = Arrays.asList(
                new Employee("Ram", 50000.0, joiningDateRam, "M"),
                new Employee("Sita", 40000.0, joiningDateSita, "F"),
                new Employee("Vishnu", 20000.0, joiningDateVishnu, "M"),
                new Employee("Mahesh", 70000.0, joiningDateMahesh, "M")
        );

        /** *
         *
         * 1. Find the maximum salary of the employee.
         * **/
        Optional<Employee> maxSalary = emp.stream().max(Comparator.comparingDouble(Employee::getSalary));
        maxSalary.ifPresent(System.out::println);

        /**
         *
         * 2. Find the second-highest salary
         */
        Optional<Employee> secondHighestSalary = emp.stream()
                .sorted((a, b)-> Double.compare(b.getSalary(), a.getSalary()))
                .skip(1)
                .findFirst();
        secondHighestSalary.ifPresent(System.out::println);

        /**
         *
         * 3. Find senior Employee based on joining date
         */
        Optional<Employee> seniorEmp = emp.stream()
                .min(Comparator.comparing(Employee::getJoiningDate));
        seniorEmp.ifPresent(System.out::println);

        /**
         *
         * 4. Count the employee based on the gender
         */
        Map<String, Long> genderCount = emp.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);

    }
}

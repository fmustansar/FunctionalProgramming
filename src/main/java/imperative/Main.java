package imperative;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Chaudhry", Gender.MALE),
            new Person("FAIZAN", Gender.MALE),
            new Person("Anum", Gender.FEMALE),
            new Person("Junaid", Gender.MALE),
            new Person("Giulia", Gender.FEMALE)
        );
        //Imperative approach
        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();
        System.out.println("FEMALES");
        for(Person person:people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for(Person person:females) {
            System.out.println(person.toString());
        }
        System.out.println("MALES");
        for(Person person:people) {
            if(Gender.MALE.equals(person.gender)) {
                males.add(person);
            }
        }
        for(Person person:males) {
            System.out.println(person.toString());
        }
    }

    @ToString
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

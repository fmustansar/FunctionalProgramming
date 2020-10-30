package declarative;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> people = List.of(
            new Human("Chaudhry", Gender.MALE),
            new Human("FAIZAN", Gender.MALE),
            new Human("Anum", Gender.FEMALE),
            new Human("Junaid", Gender.MALE),
            new Human("Giulia", Gender.FEMALE)
        );
        //Imperative approach
        System.out.println("Imperative approach");
        List<Human> females = new ArrayList<>();
        List<Human> males = new ArrayList<>();
        System.out.println("FEMALES");
        for(Human person:people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for(Human person:females) {
            System.out.println(person.toString());
        }
        System.out.println("MALES");
        for(Human person:people) {
            if(Gender.MALE.equals(person.gender)) {
                males.add(person);
            }
        }
        for(Human person:males) {
            System.out.println(person.toString());
        }

        System.out.println("Declarative approach");
        //Declarative approach
        System.out.println("MALES");
        List<Human> males2= people.stream()
                .filter(person -> Gender.MALE.equals(person.gender))
                .collect(Collectors.toList());
        males2.forEach(System.out::println);

        System.out.println("FEMALES");
        List<Human> females2= people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

    }

    @ToString
     static class Human {
        private final String name;
        private final Gender gender;

        Human(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

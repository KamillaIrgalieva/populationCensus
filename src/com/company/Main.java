package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }

        System.out.println("Количество несовершенолетних:");
        long young = persons.stream()
                .filter(Person -> Person.getAge() < 18)
                .count();
        System.out.println(young);

        System.out.println("Cписок фамилий призывников (мужчин от 18 и до 27 лет):");
        List<String> list = persons.stream()
                .filter(Person -> Person.getAge() <= 27 && Person.getAge() >= 18)
                .filter(Person -> Person.getSex().equals(Sex.MAN))
                .map(Person::getSurname)
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("Список работоспособных женщин:");
        List<String> workableWoman = persons.stream()
                .filter(Person -> Person.getAge() <= 60 && Person.getAge() >= 18)
                .filter(Person -> Person.getSex().equals(Sex.WOMAN))
                .filter(Person -> Person.getEducation().equals(Education.HIGHER))
                .map(Person::getSurname)
                .collect(Collectors.toList());
        System.out.println(workableWoman);

        System.out.println("Список работоспособных мужчин:");
        List<String> workableMan = persons.stream()
                .filter(Person -> Person.getAge() <= 65 && Person.getAge() >= 18)
                .filter(Person -> Person.getSex().equals(Sex.MAN))
                .filter(Person -> Person.getEducation().equals(Education.HIGHER))
                .map(Person::getSurname)
                .collect(Collectors.toList());
        System.out.println(workableMan);
    }
}

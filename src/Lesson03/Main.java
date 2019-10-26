package Lesson03;

import Lesson05.Person;

public class Main {
    public static void main(String[] args) {

        /**
         * Creating an array of 5 employees (object of class Person)
         * Printing out full information about those, who are older than 40
         */

        Person[] persArray = {
                new Person("Oleg Khlebnikov", "Java Programmer", "guitar_hero@me.com", "79814501619", 75000, 1995),
                new Person("Dmitrii Trofimov", "Forker", "trofimka@mail.ru", "79129532456", 300000, 1971),
                new Person("Egor Nalimov", "WoWer", "egorka@yandex.ru", "79121248834", 20000, 1996),
                new Person("Nikolai Kotkov", "Vahter", "hedshoker@yandex.ru", "79121243434", 30000, 1994),
                new Person("Ivan Vasilich", "Plumber", "none", "79129561136", 15000, 1977)
        };

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() >= 40)
                System.out.println(persArray[i].getInfo());
        }

        System.out.println("--------------------------------------------------------");

        //just to check other data
        for (int i = 0; i < persArray.length; i++) {
                System.out.println(persArray[i].getInfo());
        }
    }
}

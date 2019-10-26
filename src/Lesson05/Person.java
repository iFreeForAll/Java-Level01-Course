package Lesson05;

public class Person {
    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Person (String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println(fullName + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
    }
}

class HW5 {
    public static void main(String[] args) {
        Person[] persArray = {
                new Person("Oleg Khlebnikov", "Java Programmer", "guitar_hero@me.com", "79814501619", 75000, 26),
                new Person("Dmitrii Trofimov", "Forker", "trofimka@mail.ru", "79129532456", 300000, 41),
                new Person("Egor Nalimov", "WoWer", "egorka@yandex.ru", "79121248834", 20000, 25),
                new Person("Nikolai Kotkov", "Vahter", "hedshoker@yandex.ru", "79121243434", 30000, 26),
                new Person("Ivan Vasilich", "Plumber", "none", "79129561136", 15000, 48)
        };

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40)
                persArray[i].info();
        }
    }
}

package Lesson06;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();

//        System.out.println(cat.getJUMP_HEIGTH());
//        System.out.println(cat.getRUN_LENGTH());
//
//        System.out.println(dog.getJUMP_HEIGTH());
//        System.out.println(dog.getRUN_LENGTH());
//        System.out.println(dog.getSWIM_DISTANCE());

        System.out.println();

        cat.run(300.0f);
        cat.jump(1.5f);
        cat.swim(9.0f);

        System.out.println();

        dog.run(300.0f);
        dog.jump(1.5f);
        dog.swim(9.0f);
    }
}

package Lesson06;

public class Cat extends Animal {

    public Cat(String name, float maxJump, float maxRun, float maxSwim) {
        super("Cat", name, maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_ERROR;
    }

}

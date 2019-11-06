package Lesson06;

public class Cat extends Animal {

    private final float RUN_LENGTH = (float)(Math.random() * ((300.0f - 100.0f) + 1.0f)) + 100.0f;
    private final float JUMP_HEIGTH = (float)(Math.random() * ((3.0f - 1.0f) + 1.0f)) + 1.0f;

//    public float getRUN_LENGTH() {
//        return RUN_LENGTH;
//    }
//
//    public float getJUMP_HEIGTH() {
//        return JUMP_HEIGTH;
//    }

    @Override
    void swim(float length) {
        System.out.println("Cats don't swim, duh!");
    }

    @Override
    void run(float length) {
        if (length <= RUN_LENGTH)
            System.out.println("run: " + true);
        else
            System.out.println("run: " + false);
    }

    @Override
    void jump(float heigth) {
        if (heigth <= JUMP_HEIGTH)
            System.out.println("jump: " + true);
        else
            System.out.println("jump: " + false);
    }
}

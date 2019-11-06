package Lesson06;

public class Dog extends Animal {
    private final float RUN_LENGTH = (float)(Math.random() * ((600.0f - 400.0f) + 1.0f)) + 400.0f;
    private final float JUMP_HEIGTH = (float)(Math.random() * ((1.0f - 0.1f) + 1.0f)) + 0.1f;
    private final float SWIM_DISTANCE = (float)(Math.random() * ((15.0f - 5.0f) + 1.0f)) + 5.0f;

//    public float getRUN_LENGTH() {
//        return RUN_LENGTH;
//    }
//
//    public float getJUMP_HEIGTH() {
//        return JUMP_HEIGTH;
//    }
//
//    public float getSWIM_DISTANCE() {
//        return SWIM_DISTANCE;
//    }

    @Override
    void swim(float length) {
        if (length <= SWIM_DISTANCE)
            System.out.println("swim: " + true);
        else
            System.out.println("swim: " + false);
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

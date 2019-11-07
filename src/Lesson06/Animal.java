package Lesson06;

import java.util.Random;

public abstract class Animal {
    static final int SWIM_FAIL = 0;
    static final int SWIM_OK = 1;
    static final int SWIM_ERROR = -1;

    private String type;
    private String name;
    private float maxRun;
    private float maxSwim;
    private float maxJump;
    private final Random rnd = new Random();

    Animal(String type, String name, float maxJump, float maxRun, float maxSwim) {
        float jumpDiff = rnd.nextFloat() * 5 - 1;
        float runDiff = rnd.nextFloat() * 200 - 100;
        float swimDiff = rnd.nextFloat() * 5 - 2;

        this.type = type;
        this.name = name;
        this.maxJump = maxJump + jumpDiff;
        this.maxRun = maxRun + runDiff;
        this.maxSwim = maxSwim + swimDiff;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getMaxRun() {
        return maxRun;
    }

    public float getMaxSwim() {
        return maxSwim;
    }

    public float getMaxJump() {
        return maxJump;
    }

    protected boolean run(float distance) {
        return (distance < maxRun);
    }

    protected int swim(float distance) {
        return (distance < maxSwim) ? SWIM_OK : SWIM_FAIL;
    }

    protected boolean jump(float height) {
        return (height < maxJump);
    }
}

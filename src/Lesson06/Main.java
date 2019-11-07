package Lesson06;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Baitik", 2, 200, 1);
        Dog dog = new Dog("Ada", 0.5f, 500, 10);

        Animal[] arr = {cat, dog};
        float toJump = 1.5f;
        float toRun = 350;
        float toSwim = 5;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " can ";

            String eventName = String.format("jump max %.2fm. Tries to jump ", arr[i].getMaxJump());
            String eventResult = (arr[i].jump(toJump)) ? "succeeds" : "fails";
            System.out.println(nameString + eventName + toJump + "m, and " + eventResult);

            eventName = String.format("run max %.2fm. Tries to run ", arr[i].getMaxRun());
            eventResult = (arr[i].run(toRun)) ? "succeeds" : "fails";
            System.out.println(nameString + eventName + toRun + "m, and " + eventResult);

            int swimResults = arr[i].swim(toSwim);
            eventName = String.format("swim max %.2fm. Tries to swim ", arr[i].getMaxSwim());
            eventResult = (swimResults == Animal.SWIM_OK) ? "succeeds" : "fails";
            if (swimResults == Animal.SWIM_ERROR)
                eventResult = "couldn't do it because scares of the water...";
            System.out.println(nameString + eventName + toSwim + "m, and " + eventResult);
        }
    }
}

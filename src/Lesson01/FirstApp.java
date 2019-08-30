package Lesson01;

/* First Homework after Lesson01
We learned about:
1) Comments;
2) data types;
3) methods;
4) if-else; */

public class FirstApp {
    public static void main(String[] args) {
        //8 primitive data types
        byte b1 = 0; // from -128 to 127 (not 128, because 0 is a number too)
        short s1 = 5000; //from -32768 to 32767
        int i1 = -243554; //from 2147483648 to 2147483647
        long l1 = 2000000L; //from 9223372036854775808 to 9223372036854775807; don't forget the "L" part at the end

        float f1 = 31.24f; //from ~1,4*10^-45 to ~3,4*10^38 (used when floating part isn't important); don't forget the "f" part at the end, or it'd count as double
        double d1 = 3.14159; //from ~4,9*10^-324 to ~1,8*10^308

        char c1 = 'c'; //16bit Unicode; from '\u0000' or 0 to '\uffff' or 65,535
        boolean bool1 = true; //logic, true or false

        //checking methods
        System.out.println(mathExpression(1.4f, 2.5f, 3.0f, 4.1f));
        System.out.println(checkTwoNumbers(5, 10));
        isPositive(3);
        System.out.println(isNegative(5));
        helloUser("Oleg");
        isLeapYear(2020);
    }

    //a method that returns the result of an expression a  * (b + (c / d))
    public static float mathExpression (float a, float b, float c, float d) {
        return a  * (b + (c / d));
    }

    //A method that takes a and b and check whether their sum lays between 10 and 20. Returns true if that's the case, otherwise it returns false
    public static boolean checkTwoNumbers(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //A method that checks whether the parameter is positive or negative (0 is a positive number)
    public static void isPositive(int variable) {
        System.out.println(variable + " is " + ((variable >= 0) ? "positive" : "negative") + "!");
    }

    //A method that returns true if the parameter is negative
    public static boolean isNegative(int variable) {
        return (variable < 0);
    }

    //A method that says "hello, name" to the user
    public static void helloUser(String name) {
        System.out.println("Hello, " + name);
    }

    //A method that check whether the year is a leap-year or a common year
    public static void isLeapYear(int year) {
        System.out.println(year + " is a " + (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ? "leap-year" : "is a common year") + "!");
    }
}
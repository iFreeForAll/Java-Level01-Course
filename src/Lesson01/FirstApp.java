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
        System.out.println(mathExpression(1, 2, 3, 4));
        System.out.println(tenToTwenty(5, 10));
        posOrNeg(-5);
        System.out.println(isItNegative(5));
        helloUser("Oleg");
        isLeapYear(2019);
    }

    //a method that returns the result of an expression a  * (b + (c / d))
    public static int mathExpression (int a, int b, int c, int d) {
        int result = a  * (b + (c / d));
        return result;
    }

    //A method that takes a and b and check whether their sum lays between 10 and 20. Returns true if that's the case, otherwise it returns false
    public static boolean tenToTwenty(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //A method that checks whether the parameter is positive or negative (0 is a positive number)
    public static void posOrNeg(int a) {
        if (a >= 0) {
            System.out.println(a + " is positive!");
        } else {
            System.out.println(a + " is negative!");
        }
    }

    //A method that returns true if the parameter is negative
    public static boolean isItNegative(int a) {
        if(a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //A method that says "hello, name" to the user
    public static void helloUser(String name) {
        System.out.println("Hello, " + name);
    }

    //A method that check whether the year is a leap-year or a common year
    public static void isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " is a leap-year");
        } else {
            if(year % 400 == 0) {
                System.out.println(year + " is a leap-year");
            } else {
                System.out.println(year + " is a common year");
            }
        }
    }
}
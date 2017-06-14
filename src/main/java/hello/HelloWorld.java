package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
    }
}
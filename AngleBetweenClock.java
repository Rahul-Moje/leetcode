package main.java.com.leetcode;

import org.omg.CORBA.PRIVATE_MEMBER;

public class AngleBetweenClock {
    private static final double HOUR_DEGREE = 30;
    private static final double MIN_DEGREE = 6;
    private static final double HOUR_TO_MIN_DEGREE = 0.5;
    public static void main(String[] args) {
        AngleBetweenClock obj = new AngleBetweenClock();
        System.out.println(obj.angleClock(12,30));

    }

    public double angleClock(int hour, int minutes) {
        double difference = Math.abs(((HOUR_DEGREE*hour)%360) + (HOUR_TO_MIN_DEGREE*minutes)-(MIN_DEGREE*minutes));
        return Math.min(difference,360-difference);

    }
}

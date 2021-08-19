package Util;

public class SpeedTest {

    public static long startTime() {
        return System.nanoTime();
    }

    public static long totalTime(long startTime) {
        return System.nanoTime() - startTime;
    }


}
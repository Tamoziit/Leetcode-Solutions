
public class AngleBetweenClockHands {

    public double angleClock(int hour, int minutes) {
        double UNIT_DEG = 6.0;
        double UNIT_MIN = 2.5 / 30;

        double diffMin = Math.abs(minutes - ((hour * 5.0) % 60.0 + (minutes * UNIT_MIN)));
        double angle = diffMin * UNIT_DEG;

        return angle > 180.0 ? 360.0 - angle : angle; // acute angle only
    }

    public static void main(String[] args) {
        AngleBetweenClockHands ob = new AngleBetweenClockHands();
        int hour, minutes;

        System.out.println("TEST CASE 1:");
        hour = 12;
        minutes = 30;
        System.out.println("Input = " + hour + ":" + minutes);
        System.out.println("Output = " + ob.angleClock(hour, minutes) + " deg");

        System.out.println("TEST CASE 2:");
        hour = 3;
        minutes = 30;
        System.out.println("Input = " + hour + ":" + minutes);
        System.out.println("Output = " + ob.angleClock(hour, minutes) + " deg");

        System.out.println("TEST CASE 3:");
        hour = 3;
        minutes = 15;
        System.out.println("Input = " + hour + ":" + minutes);
        System.out.println("Output = " + ob.angleClock(hour, minutes) + " deg");

        System.out.println("TEST CASE 4:");
        hour = 1;
        minutes = 57;
        System.out.println("Input = " + hour + ":" + minutes);
        System.out.println("Output = " + ob.angleClock(hour, minutes) + " deg");
    }
}

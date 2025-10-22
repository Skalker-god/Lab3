package ua.com.kisit.lab3;

public class ClockExt2 extends ClockExt{

    private int milliseconds;

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }


    public ClockExt2(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public ClockExt2(int seconds, int milliseconds) {
        super(seconds);
        this.milliseconds = milliseconds;
    }

    public ClockExt2(int hour, int minute, int seconds, int milliseconds) {
        super(hour, minute, seconds);
        this.milliseconds = milliseconds;
    }

    public void nextMillisecond() {

        milliseconds+=100;

        if(milliseconds>1000){

            nextSeconds();
            milliseconds=0;
            // ... Додати логіку роботи програми

        }
    }

    @Override
    public String toString() {
        return "ClockExt2{" +
                "hour=" + getHour() +
                ", minute=" + getMinute() +
                ", seconds=" + getSeconds() +
                ", milliseconds=" + milliseconds +
                '}';
    }
}
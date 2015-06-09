package edu.ucsb.cs.cs185.japusen.smstimer;

public class drivingEvent extends Event {
    private double speed;

    public drivingEvent(int type, String message, String header, double speed) {
        super(type, message, header);
        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) { this.speed = speed; }
}

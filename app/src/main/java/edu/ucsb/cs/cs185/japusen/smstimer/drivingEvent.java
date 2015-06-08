package edu.ucsb.cs.cs185.japusen.smstimer;

public class drivingEvent extends Event {
    private float speed;

    public drivingEvent(int type, String message, String header, String location, float speed) {
        super(type, message, header);
        this.speed = speed;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) { this.speed = speed; }
}

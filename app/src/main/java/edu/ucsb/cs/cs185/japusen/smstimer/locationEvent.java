package edu.ucsb.cs.cs185.japusen.smstimer;

public class locationEvent extends Event {
    private String location;
    private float distance;

    public locationEvent(int type, String message, String header, String location, float distance) {
        super(type, message, header);
        this.location = location;
        this.distance = distance;
    }

    public String getLocation() {
        return this.location;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDistance(float distance) { this.distance = distance; }

}

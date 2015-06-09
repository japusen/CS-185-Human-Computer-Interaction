package edu.ucsb.cs.cs185.japusen.smstimer;

public class locationEvent extends Event {
    private String location;
    private double distance;

    public locationEvent(int type, String message, String header, String location, double distance) {
        super(type, message, header);
        this.location = location;
        this.distance = distance;
    }

    public String getLocation() {
        return this.location;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDistance(double distance) { this.distance = distance; }

}

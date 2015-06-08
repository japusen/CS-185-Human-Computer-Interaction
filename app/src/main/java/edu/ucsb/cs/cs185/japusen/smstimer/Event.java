package edu.ucsb.cs.cs185.japusen.smstimer;

public class Event {
    private int type;
    private String message;
    private String header;

    public Event(int type, String message, String header) {
        this.type = type;
        this.message = message;
        this.header = header;
    }

    public int getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public String getHeader() {
        return this.header;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String header) { this.header = header; }
}



package edu.ucsb.cs.cs185.japusen.smstimer;

public class delayEvent extends Event {
    private String time;
    private String date;

    public delayEvent(int type, String message, String header, String time, String date) {
        super(type, message, header);
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date){ this.date = date; }
}

package edu.ucsb.cs.cs185.japusen.smstimer;

public class contactEvent extends Event {
    private String number;

    public contactEvent(int type, String message, String header, String number) {
        super(type, message, header);
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

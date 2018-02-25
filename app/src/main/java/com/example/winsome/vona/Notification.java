package com.example.winsome.vona;

public class Notification {
    private String title;
    private String text;
    private String date;

    public Notification(String mainT, String subT, String dateT) {
        title = mainT;
        text = subT;
        date = dateT;

    }

    public String getmTitle() {
        return title;
    }

    public String getmText() {return text;}

    public String getmDate() {
        return date;
    }

}

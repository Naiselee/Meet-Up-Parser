package com.adrian.meetupparser.meetupparser.controller;

public class MeetUpErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public MeetUpErrorResponse() {
    }

    public MeetUpErrorResponse(int status, long timeStamp, String message) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

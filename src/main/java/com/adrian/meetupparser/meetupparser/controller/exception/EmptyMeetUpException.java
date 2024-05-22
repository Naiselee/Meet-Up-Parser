package com.adrian.meetupparser.meetupparser.controller.exception;

public class EmptyMeetUpException extends RuntimeException{

    public EmptyMeetUpException(String message){
        super(message);
    }

    public EmptyMeetUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyMeetUpException(Throwable cause) {
        super(cause);
    }

}

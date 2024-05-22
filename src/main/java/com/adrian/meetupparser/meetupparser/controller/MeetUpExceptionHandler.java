package com.adrian.meetupparser.meetupparser.controller;

import com.adrian.meetupparser.meetupparser.controller.exception.EmptyMeetUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MeetUpExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MeetUpErrorResponse> handleException(EmptyMeetUpException exc){
        MeetUpErrorResponse error = new MeetUpErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}

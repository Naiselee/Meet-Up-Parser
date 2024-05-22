package com.adrian.meetupparser.meetupparser.controller;

import com.adrian.meetupparser.meetupparser.controller.exception.EmptyMeetUpException;
import com.adrian.meetupparser.meetupparser.entity.dto.InputDTO;
import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpResponseDTO;
import com.adrian.meetupparser.meetupparser.service.IMeetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MeetUpRestController {

    @Autowired
    private IMeetUpService meetUpService;

    @PostMapping(path="/meetups")
    public  MeetUpResponseDTO meetUp(@RequestBody InputDTO input){
        if(input.data().size() == 0){
            throw new EmptyMeetUpException("The JSON provided has no available data.");
        }
        MeetUpResponseDTO meetUpResponseDTO = meetUpService.parseRequest(input.data());

        return meetUpResponseDTO;
    }

}

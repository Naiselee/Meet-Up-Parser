package com.adrian.meetupparser.meetupparser.controller;

import com.adrian.meetupparser.meetupparser.controller.exception.EmptyMeetUpException;
import com.adrian.meetupparser.meetupparser.entity.dto.InputDTO;
import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpResponseDTO;
import com.adrian.meetupparser.meetupparser.service.IMeetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class MeetUpRestController {

    @Autowired
    private IMeetUpService meetUpService;

    @PostMapping(path="/meetups")
    public  MeetUpResponseDTO meetUp(@RequestBody InputDTO input){
        if(input.data().isEmpty()){
            throw new EmptyMeetUpException("The JSON provided has no available data.");
        }

        return meetUpService.parseRequest(input.data());
    }

}

package com.adrian.meetupparser.meetupparser.service;

import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpDTO;
import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpResponseDTO;

import java.util.ArrayList;

public interface IMeetUpService {

    MeetUpResponseDTO parseRequest(ArrayList<MeetUpDTO> meetUps);
}

package com.adrian.meetupparser.meetupparser.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MeetUpDTO(String edition, String name, Date startDate, Date endDate, ArrayList<LocationDTO> location) {
}

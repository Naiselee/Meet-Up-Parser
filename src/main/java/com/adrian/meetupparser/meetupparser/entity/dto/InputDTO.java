package com.adrian.meetupparser.meetupparser.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record InputDTO(@JsonProperty("input") ArrayList<MeetUpDTO> data) {
}

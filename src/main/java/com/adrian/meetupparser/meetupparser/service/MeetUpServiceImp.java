package com.adrian.meetupparser.meetupparser.service;

import com.adrian.meetupparser.meetupparser.entity.dto.LocationDTO;
import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpDTO;
import com.adrian.meetupparser.meetupparser.entity.dto.MeetUpResponseDTO;
import org.slf4j.event.KeyValuePair;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeetUpServiceImp implements IMeetUpService {

    @Override
    public MeetUpResponseDTO parseRequest(ArrayList<MeetUpDTO> meetUps) {
        List<String> parsedMeetUps = new ArrayList<>();
        meetUps.stream().forEach(meetUp -> {
            parsedMeetUps.add(parseMeetUp(meetUp));
        });
        return new MeetUpResponseDTO(parsedMeetUps);
    }


    /**
     * @param meetUp - Grabs a meet up and parses the object to the desired string.
     *               The format is {edition} {name} · {startDate} / {endDate} · {city}, {state}. {country} | {city}, {state}. {country}
     * @return
     */
    private String parseMeetUp(MeetUpDTO meetUp) {
        StringBuilder sb = new StringBuilder();
        //check whether there is an edition or not
        if(meetUp.edition() != null) sb.append(meetUp.edition()).append(" ");
        //append the meetup name and add a separator
        sb.append(meetUp.name());
        addSeparator(sb, "·");
        //add start date and enddate if there is and add a separator
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(meetUp.startDate()));
        if (meetUp.endDate() == null) {
            addSeparator(sb, "·");
        } else {
            addSeparator(sb, "/");
            sb.append(new SimpleDateFormat("yyyy-MM-dd").format(meetUp.endDate()));
            addSeparator(sb, "·");
        }
        //checks city, country, state, if there are more than 2 cities with the same country, only print the country
        //once separated by a " | "
        sb.append(checkCitiesPerCountry(meetUp.location()));

        return sb.toString();
    }

    private StringBuilder checkCitiesPerCountry(ArrayList<LocationDTO> locations){
        Map<String, List<LocationDTO>> citiesPerCountry = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<LocationDTO> locationsInCountry;
        for(LocationDTO location : locations){
            if(!citiesPerCountry.containsKey(location.country())){
                locationsInCountry= new ArrayList<>();
            } else {
                locationsInCountry = citiesPerCountry.get(location.country());
            }
            locationsInCountry.add(location);
            citiesPerCountry.put(location.country(), locationsInCountry);
        }

        for(String country : citiesPerCountry.keySet()){
            locationsInCountry = citiesPerCountry.get(country);
            for (LocationDTO locationDTO : locationsInCountry) {

                if (locationDTO.city() == null && locationDTO.state() != null) {
                    sb.append(locationDTO.state());

                } else if (locationDTO.city() != null && locationDTO.state() == null) {
                    sb.append(locationDTO.city());
                } else {
                    sb.append(locationDTO.city()).append(", ");
                    sb.append(locationDTO.state()).append(". ");
                }

                addSeparator(sb, "|");
            }
            sb.delete(sb.length()-3, sb.length());
            if(sb.substring(sb.length()-2).equals(". ")){
                sb.append(country);
            } else {
                sb.append(", ").append(country);
            }
            addSeparator(sb,"|");
        }

        return sb.delete(sb.length()-3, sb.length());
    }

    private void addSeparator(StringBuilder sb, String separator){
        sb.append(" ").append(separator).append(" ");
    }
}

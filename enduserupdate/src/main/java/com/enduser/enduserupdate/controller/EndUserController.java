package com.enduser.enduserupdate.controller;

import com.enduser.enduserupdate.constant.AppConstants;
import com.enduser.enduserupdate.entity.Location;
import com.enduser.enduserupdate.service.LocationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class EndUserController {

    private final List<List<Integer>> consumedLocations = new ArrayList<>();
    @Autowired
    private LocationService locationService;
    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void consumeLocation(List<Integer> location, ConsumerRecord<String, List<Integer>> record) {

        System.out.println("Consumed location: " + location);
        consumedLocations.add(location);
    }
    @PostMapping
    public List<List<Integer>> addLocation()
    {
        for (List<Integer> location:consumedLocations
             ) {
            Location location1=new Location(location.get(0),location.get(1));
           locationService.addLocation(location1);
            
        }
        return consumedLocations;
    }

    @GetMapping
    public List<Location> getConsumedLocations() {
        return locationService.getallLocation();
    }
}

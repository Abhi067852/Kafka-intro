package com.enduser.enduserupdate.controller;

import com.enduser.enduserupdate.config.KafkaConsumerConfig;
import com.enduser.enduserupdate.constant.AppConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class EndUserController {
    private final List<String> consumedLocations = new ArrayList<>();

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void consumeLocation(String location, ConsumerRecord<String, String> record) {

        System.out.println("Consumed location: " + location);
        consumedLocations.add(location);
    }

    @GetMapping
    public List<String> getConsumedLocations() {
        // Provide the list of consumed locations
        return consumedLocations;
    }
}

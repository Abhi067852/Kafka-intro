package com.deliveryboy.deliveryboyapp.controller;


import com.deliveryboy.deliveryboyapp.service.KafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
   @Autowired
   private KafkaService kafkaService;
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation()
    {
        List<Integer> p1=new ArrayList<>();
        int lat = (int) (Math.random() * 100);
        int longi=(int) (Math.random() * 100);
        p1.add(lat);
        p1.add(longi);

        this.kafkaService.updateLocation(p1);
         return new ResponseEntity<>(Map.of("message","location updated"), HttpStatus.OK);
    }
}

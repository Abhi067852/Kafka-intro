package com.deliveryboy.deliveryboyapp.service;

import com.deliveryboy.deliveryboyapp.config.AppConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaService {
@Autowired
    private KafkaTemplate<String, List<Integer>> kafkaTemplate;
   private Logger logger= LoggerFactory.getLogger(KafkaService.class);
public boolean updateLocation(List<Integer> location){
this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
this.logger.info("message produced"+location.get(0)+location.get(1));
return true;

}
}

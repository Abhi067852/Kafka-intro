package com.enduser.enduserupdate.service;

import com.enduser.enduserupdate.entity.Location;
import com.enduser.enduserupdate.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location addLocation(Location location) {
       return locationRepository.save(location);
    }

    @Override
    public List<Location> getallLocation() {
        return locationRepository.findAll();
    }


}

package com.enduser.enduserupdate.service;

import com.enduser.enduserupdate.entity.Location;

import java.util.List;

public interface LocationService {
    Location addLocation(Location location);
    List<Location> getallLocation();
}

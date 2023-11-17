package com.enduser.enduserupdate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="location")
public class Location {
    public Location(Integer lat, Integer longi) {
        this.lat = lat;
        this.longi = longi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer lat;
    private Integer longi;

}

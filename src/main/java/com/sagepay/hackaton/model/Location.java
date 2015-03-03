package com.sagepay.hackaton.model;

import org.springframework.data.annotation.Id;

public class Location {
    @Id
    private String id;

    private String postcode;
    private String area;
    private String region;

    public Location() {}

    public Location(String postcode, String area, String region) {
        this.postcode = postcode;
        this.area = area;
        this.region = region;
    }

    @Override
    public String toString() {
        return String.format(
                "Location[id=%s, postcode='%s', area='%s', region='%s']",
                id, postcode, area, region);
    }
}

package com.sagepay.hackathon.model;

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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return String.format(
                "Location[id=%s, postcode='%s', area='%s', region='%s']",
                id, postcode, area, region);
    }
}

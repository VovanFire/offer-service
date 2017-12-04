package com.fire.offer.offerservice.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "Photos_of_offers";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

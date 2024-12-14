package com.sda.sdaspring.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity(name = "tracking_devices")
public class TrackingDevice extends BaseEntity{
    private String serialNumber;
    private LocalDate activationDate;

    @OneToOne(mappedBy = "trackingDevice")
    private Bird bird;

    public TrackingDevice() {

    }

    public TrackingDevice(String serialNumber, String activationDate) {
        this.serialNumber = serialNumber;
        this.activationDate = LocalDate.parse(activationDate);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public Bird getBird() {
        return bird;
    }
}

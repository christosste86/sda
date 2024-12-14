package com.sda.sdaspring.models;

import javax.persistence.*;

@Entity
@Table(name = "birds")
public class Bird extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(name = "can_fly")
    private boolean canFly;
    private int weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_device_id", referencedColumnName = "id")
    private TrackingDevice trackingDevice;

    public Bird() {
    }

    public Bird(String name, boolean canFly, int weight) {
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getWeight() {
        return weight;
    }

    public TrackingDevice getTrackingDevice() {
        return trackingDevice;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTrackingDevice(TrackingDevice trackingDevice) {
        this.trackingDevice = trackingDevice;
    }
}

package org.sda.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity(name = "habitats")
public class Habitat extends BaseEntity {

    private String type;
    private String location;

    @OneToOne(mappedBy = "habitat")
    private Bird bird;

    public Habitat(String type, String location) {
        this.type = type;
        this.location = location;
    }
}

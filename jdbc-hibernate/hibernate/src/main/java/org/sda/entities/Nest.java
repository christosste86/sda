package org.sda.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "nests")
public class Nest extends BaseEntity{
    private String name;
    private Integer capacity;
    private String material;

    @OneToMany(mappedBy = "nest")
    private List<Bird> birds;

    public Nest(String name, Integer capacity, String material) {
        this.name = name;
        this.capacity = capacity;
        this.material = material;
    }
}

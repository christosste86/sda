package org.sda.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "foods")
public class Food extends BaseEntity{
    private String name;
    private  Integer calories;

    @ManyToMany(mappedBy = "foods")
    private List<Bird> birds;

    public Food(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }
}

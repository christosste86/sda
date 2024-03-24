package org.sda.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "birds")
@Entity
public class Bird extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(name = "can_fly")
    private boolean canFly;
    private int weight;

    @OneToOne
    @JoinColumn(name = "habitats_id")
    private Habitat habitat;

    @ManyToOne
    @JoinColumn(name = "nests_id")
    private Nest nest;

    @ManyToMany
    @JoinTable(
            name = "birds_foods",
            joinColumns = @JoinColumn(name = "bird_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> foods;

    public Bird(String name, boolean canFly, int weight) {
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }
}

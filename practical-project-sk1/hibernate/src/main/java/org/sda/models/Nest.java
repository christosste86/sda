package org.sda.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "nests")
public class Nest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer capacity;

    private String material;


    @OneToMany(mappedBy = "nest")
    private List<Bird> birds = new ArrayList<>();

    public Nest() {
    }

    public Nest(String name, Integer capacity, String material) {
        this.name = name;
        this.capacity = capacity;
        this.material = material;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBird(Bird bird){
        birds.add(bird);
        bird.setNest(this);
    }


    @Override
    public String toString() {
        return "Nest{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", material='" + material + '\'' +
                '}';
    }
}

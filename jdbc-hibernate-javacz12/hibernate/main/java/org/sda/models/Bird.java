package org.sda.models;

import javax.persistence.*;

@Entity
@Table(name = "birds")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "can_fly")
    private boolean canFly;
    private int weight;

    @ManyToOne
    @JoinColumn(name = "nests_id")
    private Nest nest;

    public Bird() {
    }

    public Bird(String name, boolean canFly, int weight) {
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setNest(Nest nest) {
        this.nest = nest;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", canFly=" + canFly +
                ", weight=" + weight +
                '}';
    }
}

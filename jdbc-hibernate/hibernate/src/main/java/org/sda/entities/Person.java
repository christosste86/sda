package org.sda.entities;

import lombok.*;

import javax.persistence.*;


@Entity // annotation from JPA - Hibernate
@Table(name = "people")
@Data // = @Getter + @Setter
//@Getter
//@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor // constructor for attribute which are private and final
public class Person {

    @Id // annotation from JPA - Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation from JPA - Hibernate
    private int id;

    @Embedded
    private Name name;

//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;

    public Person(Name name) {
        this.name = name;
    }
}

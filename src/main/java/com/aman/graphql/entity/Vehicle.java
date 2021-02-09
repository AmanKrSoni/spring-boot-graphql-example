package com.aman.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vehicle implements Serializable {

    private static final Long serialVersionUID = 1l;

    @Id
    @Column(name = "ID", nullable =  false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;
    private String model;
    private String brandName;
    private LocalDate launchDate;
    private transient String formattedDate;
}

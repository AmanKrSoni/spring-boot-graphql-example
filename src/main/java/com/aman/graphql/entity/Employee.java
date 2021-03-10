package com.aman.graphql.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Slf4j
@NoArgsConstructor
public class Employee implements Serializable {

    private static final Long serialVersionUID = 1l;

    @Id
    @Column(name = "ID", nullable =  false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Name name;
    private Address address;
    private Position position;
}

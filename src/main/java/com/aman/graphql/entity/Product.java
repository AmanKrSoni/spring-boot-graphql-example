package com.aman.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long productId = null;
    @Version
    @Column(name = "version")
    private int version = 0;

    @Column
    private String name;
}

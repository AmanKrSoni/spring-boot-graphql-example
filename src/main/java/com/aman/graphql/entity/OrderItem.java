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
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    @Version
    @Column(name = "version")
    private int version = 0;

    @Column
    private int quantity;

    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Product product;
}

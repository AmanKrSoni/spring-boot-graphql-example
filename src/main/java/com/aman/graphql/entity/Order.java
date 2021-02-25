package com.aman.graphql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "purchaseOrder")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties( ignoreUnknown = true)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;
    @Version
    @Column(name = "version")
    private int version = 0;

    @Column
    private String orderNumber;

    private String createdAt = LocalDateTime.now().toString();

    @OneToMany(targetEntity = OrderItem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();
}

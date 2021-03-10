package com.aman.graphql.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
public class Address implements Serializable {

    private String country;
    private String state;
    private String city;
    private String zipCode;
}

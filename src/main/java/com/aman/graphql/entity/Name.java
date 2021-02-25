package com.aman.graphql.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
public class Name implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
}

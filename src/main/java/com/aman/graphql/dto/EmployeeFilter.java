package com.aman.graphql.dto;

import com.aman.graphql.entity.Position;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeFilter implements Serializable {
    private int id;
    private String firstName;
    private String country;
    private Position position;
}

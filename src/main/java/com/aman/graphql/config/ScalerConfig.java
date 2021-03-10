package com.aman.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalerConfig {

    @Bean
    public GraphQLScalarType date(){
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType dateTime(){
        return ExtendedScalars.DateTime;
    }
}

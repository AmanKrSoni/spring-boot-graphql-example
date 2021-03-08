package com.aman.graphql.exceptions;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
//import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomGraphQLExceptionHandler implements GraphQLErrorHandler {
    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return !errors.isEmpty();
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list;
    }
}

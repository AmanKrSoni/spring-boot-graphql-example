package com.aman.graphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class EmployeeNameAlreadyExistException extends RuntimeException implements GraphQLError {
    public EmployeeNameAlreadyExistException(String message) {
        super(message);
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}

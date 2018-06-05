package org.deepti.tuts.GraphQLTuts.errorhandler;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.deepti.tuts.GraphQLTuts.model.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deeptim on 6/5/18.
 */
public class AuthorNotFoundException extends RuntimeException implements GraphQLError{

    private Map<String, Object> extensions = new HashMap<>();

    public AuthorNotFoundException(String message, long id) {
        super(message);
        extensions.put("This author is not present", id);
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}

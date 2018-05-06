package org.deepti.tuts.GraphQLTuts.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorFilter {
    private  String authorName;

    @JsonProperty("AuthorName")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}

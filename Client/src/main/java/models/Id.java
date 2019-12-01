package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * POJO for an Id object
 */
public class Id {
    //@JsonProperty(string"name")  //Not necessary because the fields in the JSON match our variable
    private String name;
    @JsonProperty("github")  //The JSON file is using github but we want it to recognize githubId
    private String githubId;
    @JsonProperty("userid") //the JSON file is using lower case 'i' but we need it to be capital 'I'
    private String userId;

    public Id(){}
    
    public Id (String name, String githubId) {
        this.name = name;
        this.githubId = githubId;
        this.userId = "-"; //this is needed by JSON
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }
}
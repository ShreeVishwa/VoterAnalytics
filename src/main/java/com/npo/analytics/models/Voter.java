package com.npo.analytics.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Voter {
    private String firstName;
    private String lastName;
    private String email;
    private String state;
    private Integer zip;
    private Integer age;
    private String gender;
    private String votingExperience;

    @JsonCreator
    public Voter(@JsonProperty("firstName") String firstName,
                 @JsonProperty("lastName") String lastName,
                 @JsonProperty("email") String email,
                 @JsonProperty("state") String state,
                 @JsonProperty("gender") String gender,
                 @JsonProperty("votingExperience") String votingExperience,
                 @JsonProperty("age") Integer age,
                 @JsonProperty("zip") Integer zip) {
        this.age = age;
        this.zip = zip;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.state = state;
        this.votingExperience = votingExperience;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("votingExperience")
    public String getVotingExperience() {
        return votingExperience;
    }

    public void setVotingExperience(String votingExperience) {
        this.votingExperience = votingExperience;
    }
}

package com.npo.analytics.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VoterCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String state;
    private Integer zip;
    private Integer age;
    private String gender;
    private String votingExperience;
}

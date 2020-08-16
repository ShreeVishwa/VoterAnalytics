package com.npo.analytics.converter;

import com.npo.analytics.command.VoterCommand;
import com.npo.analytics.models.Voter;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class VoterCommandToVoter implements Converter<VoterCommand, Voter> {

    @Override
    @Synchronized
    @Nullable
    public Voter convert(VoterCommand voterCommand) {
        if (voterCommand == null) return null;
        final Voter voter = new Voter();
        voter.setAge(voterCommand.getAge());
        voter.setFirstName(voterCommand.getFirstName());
        voter.setLastName(voterCommand.getLastName());
        voter.setEmail(voterCommand.getLastName());
        voter.setZip(voterCommand.getZip());
        voter.setGender(voterCommand.getGender());
        voter.setState(voterCommand.getState());
        voter.setVotingExperience(voterCommand.getVotingExperience());
        return voter;
    }
}

package com.npo.analytics.service;

import com.npo.analytics.command.VoterCommand;
import com.npo.analytics.converter.VoterCommandToVoter;
import com.npo.analytics.models.ConnectToLedger;
import com.npo.analytics.models.Constants;
import com.npo.analytics.models.Voter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.npo.analytics.models.InsertData.insertDocuments;

@Service
public class VoterServiceImpl implements VoterService {

    private final VoterCommandToVoter voterCommandToVoter;

    public VoterServiceImpl(VoterCommandToVoter voterCommandToVoter) {
        this.voterCommandToVoter = voterCommandToVoter;
    }

    @Override
    public VoterCommand saveVoter(VoterCommand voterCommand) {
        Voter voter = voterCommandToVoter.convert(voterCommand);
        List<Voter> voters = new ArrayList<>();
        voters.add(voter);
        ConnectToLedger.getDriver().execute(txn -> {
            insertDocuments(txn, Constants.VOTER_REGISTRATION_TABLE_NAME,
                    Collections.unmodifiableList(voters));
        }, (retryAttempt) -> System.out.println("Retrying due to OCC conflict..."));
        System.out.println("Voter successfully registered");
        return voterCommand;
    }
}

package com.npo.analytics.service;

import com.npo.analytics.command.VoterCommand;

public interface VoterService {
    VoterCommand saveVoter(VoterCommand voterCommand);
}

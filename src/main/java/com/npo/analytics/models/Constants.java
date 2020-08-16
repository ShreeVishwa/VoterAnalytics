package com.npo.analytics.models;

import com.amazon.ion.IonSystem;
import com.amazon.ion.system.IonSystemBuilder;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.ion.IonObjectMapper;
import com.fasterxml.jackson.dataformat.ion.ionvalue.IonValueMapper;

public final class Constants {
    public static final int RETRY_LIMIT = 4;
    public static final String LEDGER_NAME = "voter-registration";
    public static final String STREAM_NAME = "voter-registration-stream";
    public static final String VOTER_REGISTRATION_TABLE_NAME = "VoterRegistration";

    public static final IonSystem SYSTEM = IonSystemBuilder.standard().build();
    public static final IonObjectMapper MAPPER = new IonValueMapper(SYSTEM);

    private Constants() { }

    static {
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}

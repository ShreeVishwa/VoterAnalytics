package com.npo.analytics.models;

import com.amazon.ion.IonValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.qldb.TransactionExecutor;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class InsertData {
    public static final Logger log = LoggerFactory.getLogger(InsertData.class);

    private InsertData() { }

    public static List<String> insertDocuments(final TransactionExecutor txn, final String tableName,
                                               final List documents) {
        log.info("Inserting some documents in the {} table...", tableName);
        try {
            final String statement = String.format("INSERT INTO %s ?", tableName);
            final IonValue ionDocuments = Constants.MAPPER.writeValueAsIonValue(documents);
            final List<IonValue> parameters = Collections.singletonList(ionDocuments);
            return SampleData.getDocumentIdsFromDmlResult(txn.execute(statement, parameters));
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        }
    }
}

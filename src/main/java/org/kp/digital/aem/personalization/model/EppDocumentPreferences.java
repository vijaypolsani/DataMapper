package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "document")
public class EppDocumentPreferences {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed
    @DatabaseField(canBeNull = true, columnName = "epp_PersonRole")
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DocumentName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationChannelTypeName;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AdobeRecord adobeRecord;

    public EppDocumentPreferences() {
        // ORMLite needs a no-arg constructor
    }

}

package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "communication")
public class EppCommunicationPreferences {

    @Parsed
    @DatabaseField(canBeNull = true, columnName = "epp_PersonRole")
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationTypeName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationSubTypeName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationChannelTypeName;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AdobeRecord adobeRecord;

    public EppCommunicationPreferences() {
        // ORMLite needs a no-arg constructor
    }

}

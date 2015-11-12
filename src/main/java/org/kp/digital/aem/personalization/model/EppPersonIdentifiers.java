package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "epp")
public class EppPersonIdentifiers {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed
    @DatabaseField(id = true)
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierKey;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierPrefix;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierRegionCode;

    public EppPersonIdentifiers() {
        // ORMLite needs a no-arg constructor
    }

}

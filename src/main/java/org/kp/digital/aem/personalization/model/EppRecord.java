package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "EppTable")
public class EppRecord {

    @DatabaseField(id = true)
    private String sequenceNumber;

    @DatabaseField
    private String epp_PersonRole;

    public EppRecord() {
        // ORMLite needs a no-arg constructor
    }

}

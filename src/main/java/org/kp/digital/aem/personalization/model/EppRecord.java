package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "Epp")
public class EppRecord {


    @DatabaseField (id=true)
    private String epp_PersonRole;

    @DatabaseField(generatedId = true)
    private String sequenceNumber;

    public EppRecord() {
        // ORMLite needs a no-arg constructor
    }

}

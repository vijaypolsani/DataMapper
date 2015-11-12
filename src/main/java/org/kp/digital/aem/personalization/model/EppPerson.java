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
public class EppPerson {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed(field = "epp_PersonRoleid")
    @DatabaseField(id = true, columnName = "epp_PersonRole")
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_FirstName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MiddleName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_LastName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_NameSuffix;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PreferredFirstName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_GenderName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_BirthDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DeathDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DeceasedIndicator;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MaritalStatusIdName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_RaceName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_RaceEthnicityIdName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageOnlineIdName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageSpokenName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageWrittenName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DoNotCall;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DoNotEmail;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DoNotMail;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DoNotSMS;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_BrokeredIndicator;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_BrokerId;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CIMPMembershipKey;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_GrandfatheredPlan;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_KPMedicareMember;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MedicaidIndicator;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MedicareEligByDisability;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_TobaccoUseIndicator;

    public EppPerson() {
        // ORMLite needs a no-arg constructor
    }

}

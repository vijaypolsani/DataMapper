package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "contact")
public class EppContactMethods {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed
    @DatabaseField(canBeNull = true, columnName = "epp_PersonRole")
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ContactMethodType;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressType;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_EmailType;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PhoneType;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressLine1;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressLine2;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressLIne3;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressCity;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ContactMethodStateIdName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressState;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressZip;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressZip4;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressCounty;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_AddressCountry;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryAddressFlag;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PreferredAddressflag;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_Email;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryEmail;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_preferredemailflag;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PhoneAreaCode;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PhoneCountryCode;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PhoneNumber;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PhoneExt;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryPhone;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_preferredphoneflag;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AdobeRecord adobeRecord;


    public EppContactMethods() {
        // ORMLite needs a no-arg constructor
    }

}

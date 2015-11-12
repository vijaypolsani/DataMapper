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
public class EppRecord {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed(field = "epp_PersonRole")
    @DatabaseField(id = true, columnName = "epp_PersonRole")
    private String epp_PersonRole;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MemberContractOptionBenefitKey;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ContractOptionKey;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_GroupNo;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_SubGroupNo;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PlanId;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_PlanName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ProductShortName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_Deductible;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_OutOfPocketMax;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CoPayPCPVisit;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CoPayLabs;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CoPayRadiology;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_effectivefromdate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_effectivetilldate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MembershipContractStartDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_MembershipContractEndDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ContractEffectiveStartDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_ContractEffectiveEndDate;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationTypeName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationSubTypeName;
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationChannelTypeName;
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
    @Parsed
    @DatabaseField(canBeNull = true)
    private String epp_DocumentName;
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
    public EppRecord() {
        // ORMLite needs a no-arg constructor
    }

}

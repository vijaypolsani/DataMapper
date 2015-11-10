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

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @DatabaseField(id = true)
    private String epp_PersonRole;
    @DatabaseField(canBeNull = true)
    private String epp_MemberContractOptionBenefitKey;
    @DatabaseField(canBeNull = true)
    private String epp_ContractOptionKey;
    @DatabaseField(canBeNull = true)
    private String epp_GroupNo;
    @DatabaseField(canBeNull = true)
    private String epp_SubGroupNo;
    @DatabaseField(canBeNull = true)
    private String epp_PlanId;
    @DatabaseField(canBeNull = true)
    private String epp_PlanName;
    @DatabaseField(canBeNull = true)
    private String epp_ProductShortName;
    @DatabaseField(canBeNull = true)
    private String epp_Deductible;
    @DatabaseField(canBeNull = true)
    private String epp_OutOfPocketMax;
    @DatabaseField(canBeNull = true)
    private String epp_CoPayPCPVisit;
    @DatabaseField(canBeNull = true)
    private String epp_CoPayLabs;
    @DatabaseField(canBeNull = true)
    private String epp_CoPayRadiology;
    @DatabaseField(canBeNull = true)
    private String epp_effectivefromdate;
    @DatabaseField(canBeNull = true)
    private String epp_effectivetilldate;
    @DatabaseField(canBeNull = true)
    private String epp_MembershipContractStartDate;
    @DatabaseField(canBeNull = true)
    private String epp_MembershipContractEndDate;
    @DatabaseField(canBeNull = true)
    private String epp_ContractEffectiveStartDate;
    @DatabaseField(canBeNull = true)
    private String epp_ContractEffectiveEndDate;
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationTypeName;
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationSubTypeName;
    @DatabaseField(canBeNull = true)
    private String epp_CommunicationChannelTypeName;
    @DatabaseField(canBeNull = true)
    private String epp_ContactMethodType;
    @DatabaseField(canBeNull = true)
    private String epp_AddressType;
    @DatabaseField(canBeNull = true)
    private String epp_EmailType;
    @DatabaseField(canBeNull = true)
    private String epp_PhoneType;
    @DatabaseField(canBeNull = true)
    private String epp_AddressLine1;
    @DatabaseField(canBeNull = true)
    private String epp_AddressLine2;
    @DatabaseField(canBeNull = true)
    private String epp_AddressLIne3;
    @DatabaseField(canBeNull = true)
    private String epp_AddressCity;
    @DatabaseField(canBeNull = true)
    private String epp_ContactMethodStateIdName;
    @DatabaseField(canBeNull = true)
    private String epp_AddressState;
    @DatabaseField(canBeNull = true)
    private String epp_AddressZip;
    @DatabaseField(canBeNull = true)
    private String epp_AddressZip4;
    @DatabaseField(canBeNull = true)
    private String epp_AddressCounty;
    @DatabaseField(canBeNull = true)
    private String epp_AddressCountry;
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryAddressFlag;
    @DatabaseField(canBeNull = true)
    private String epp_PreferredAddressflag;
    @DatabaseField(canBeNull = true)
    private String epp_Email;
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryEmail;
    @DatabaseField(canBeNull = true)
    private String epp_preferredemailflag;
    @DatabaseField(canBeNull = true)
    private String epp_PhoneAreaCode;
    @DatabaseField(canBeNull = true)
    private String epp_PhoneCountryCode;
    @DatabaseField(canBeNull = true)
    private String epp_PhoneNumber;
    @DatabaseField(canBeNull = true)
    private String epp_PhoneExt;
    @DatabaseField(canBeNull = true)
    private String epp_PrimaryPhone;
    @DatabaseField(canBeNull = true)
    private String epp_preferredphoneflag;
    @DatabaseField(canBeNull = true)
    private String epp_DocumentName;
    @DatabaseField(canBeNull = true)
    private String epp_FirstName;
    @DatabaseField(canBeNull = true)
    private String epp_MiddleName;
    @DatabaseField(canBeNull = true)
    private String epp_LastName;
    @DatabaseField(canBeNull = true)
    private String epp_NameSuffix;
    @DatabaseField(canBeNull = true)
    private String epp_PreferredFirstName;
    @DatabaseField(canBeNull = true)
    private String epp_GenderName;
    @DatabaseField(canBeNull = true)
    private String epp_BirthDate;
    @DatabaseField(canBeNull = true)
    private String epp_DeathDate;
    @DatabaseField(canBeNull = true)
    private String epp_DeceasedIndicator;
    @DatabaseField(canBeNull = true)
    private String epp_MaritalStatusIdName;
    @DatabaseField(canBeNull = true)
    private String epp_RaceName;
    @DatabaseField(canBeNull = true)
    private String epp_RaceEthnicityIdName;
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageOnlineIdName;
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageSpokenName;
    @DatabaseField(canBeNull = true)
    private String epp_PreferredLanguageWrittenName;
    @DatabaseField(canBeNull = true)
    private String epp_DoNotCall;
    @DatabaseField(canBeNull = true)
    private String epp_DoNotEmail;
    @DatabaseField(canBeNull = true)
    private String epp_DoNotMail;
    @DatabaseField(canBeNull = true)
    private String epp_DoNotSMS;
    @DatabaseField(canBeNull = true)
    private String epp_BrokeredIndicator;
    @DatabaseField(canBeNull = true)
    private String epp_BrokerId;
    @DatabaseField(canBeNull = true)
    private String epp_CIMPMembershipKey;
    @DatabaseField(canBeNull = true)
    private String epp_GrandfatheredPlan;
    @DatabaseField(canBeNull = true)
    private String epp_KPMedicareMember;
    @DatabaseField(canBeNull = true)
    private String epp_MedicaidIndicator;
    @DatabaseField(canBeNull = true)
    private String epp_MedicareEligByDisability;
    @DatabaseField(canBeNull = true)
    private String epp_TobaccoUseIndicator;
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierName;
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierKey;
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierPrefix;
    @DatabaseField(canBeNull = true)
    private String epp_SourceSystemIdentifierRegionCode;
    @DatabaseField(canBeNull = true)
    private String ModifiedOn;
    @DatabaseField(canBeNull = true)
    private String ModifiedByName;
    public EppRecord() {
        // ORMLite needs a no-arg constructor
    }

}

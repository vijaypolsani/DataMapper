package org.kp.digital.aem.personalization.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;
import org.kp.digital.aem.personalization.util.KeyMapper;

/**
 * Created by vijay on 11/5/15.
 */
@Data
@DatabaseTable(tableName = "epp")
public class EppRecord {
    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed(field = "epp_PersonRole")
    @DatabaseField(id = true, columnName = "epp_PersonRole", canBeNull = false)
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

    public String adobeAamFormat() {
        return epp_PersonRole + "\t" +
                "\"" + KeyMapper.epp_MemberContractOptionBenefitKey.getName() + "\"=\"" +
                epp_MemberContractOptionBenefitKey + "\"," +
                "\"" + KeyMapper.epp_ContractOptionKey.getName() + "\"=\"" + epp_ContractOptionKey + "\"," +
                "\"" + KeyMapper.epp_GroupNo.getName() + "\"=\"" + epp_GroupNo + "\"," +
                "\"" + KeyMapper.epp_SubGroupNo.getName() + "\"=\"" + epp_SubGroupNo + "\"," +
                "\"" + KeyMapper.epp_PlanId.getName() + "\"=\"" + epp_PlanId + "\"," +
                "\"" + KeyMapper.epp_PlanName.getName() + "\"=\"" + epp_PlanName + "\"," +
                "\"" + KeyMapper.epp_ProductShortName.getName() + "\"=\"" + epp_ProductShortName + "\"," +
                "\"" + KeyMapper.epp_Deductible.getName() + "\"=\"" + epp_Deductible + "\"," +
                "\"" + KeyMapper.epp_OutOfPocketMax.getName() + "\"=\"" + epp_OutOfPocketMax + "\"," +
                "\"" + KeyMapper.epp_CoPayPCPVisit.getName() + "\"=\"" + epp_CoPayPCPVisit + "\"," +
                "\"" + KeyMapper.epp_CoPayLabs.getName() + "\"=\"" + epp_CoPayLabs + "\"," +
                "\"" + KeyMapper.epp_CoPayRadiology.getName() + "\"=\"" + epp_CoPayRadiology + "\"," +
                "\"" + KeyMapper.epp_effectivefromdate.getName() + "\"=\"" + epp_effectivefromdate + "\"," +
                "\"" + KeyMapper.epp_effectivetilldate.getName() + "\"=\"" + epp_effectivetilldate + "\"," +
                "\"" + KeyMapper.epp_MembershipContractStartDate.getName() + "\"=\"" +
                epp_MembershipContractStartDate + "\"," +
                "\"" + KeyMapper.epp_MembershipContractEndDate.getName() + "\"=\"" + epp_MembershipContractEndDate +
                "\"," +
                "\"" + KeyMapper.epp_ContractEffectiveStartDate.getName() + "\"=\"" + epp_ContractEffectiveStartDate
                + "\"," +
                "\"" + KeyMapper.epp_ContractEffectiveEndDate.getName() + "\"=\"" + epp_ContractEffectiveEndDate +
                "\"," +
                "\"" + KeyMapper.epp_CommunicationTypeName.getName() + "\"=\"" + epp_CommunicationTypeName + "\"," +
                "\"" + KeyMapper.epp_CommunicationSubTypeName.getName() + "\"=\"" + epp_CommunicationSubTypeName +
                "\"," +
                "\"" + KeyMapper.epp_CommunicationChannelTypeName.getName() + "\"=\"" +
                epp_CommunicationChannelTypeName + "\"," +
                "\"" + KeyMapper.epp_ContactMethodType.getName() + "\"=\"" + epp_ContactMethodType + "\"," +
                "\"" + KeyMapper.epp_AddressType.getName() + "\"=\"" + epp_AddressType + "\"," +
                "\"" + KeyMapper.epp_EmailType.getName() + "\"=\"" + epp_EmailType + "\"," +
                "\"" + KeyMapper.epp_PhoneType.getName() + "\"=\"" + epp_PhoneType + "\"," +
                "\"" + KeyMapper.epp_AddressLine1.getName() + "\"=\"" + epp_AddressLine1 + "\"," +
                "\"" + KeyMapper.epp_AddressLine2.getName() + "\"=\"" + epp_AddressLine2 + "\"," +
                "\"" + KeyMapper.epp_AddressLIne3.getName() + "\"=\"" + epp_AddressLIne3 + "\"," +
                "\"" + KeyMapper.epp_AddressCity.getName() + "\"=\"" + epp_AddressCity + "\"," +
                "\"" + KeyMapper.epp_ContactMethodStateIdName.getName() + "\"=\"" + epp_ContactMethodStateIdName +
                "\"," +
                "\"" + KeyMapper.epp_AddressState.getName() + "\"=\"" + epp_AddressState + "\"," +
                "\"" + KeyMapper.epp_AddressZip.getName() + "\"=\"" + epp_AddressZip + "\"," +
                "\"" + KeyMapper.epp_AddressZip4.getName() + "\"=\"" + epp_AddressZip4 + "\"," +
                "\"" + KeyMapper.epp_AddressCounty.getName() + "\"=\"" + epp_AddressCounty + "\"," +
                "\"" + KeyMapper.epp_AddressCountry.getName() + "\"=\"" + epp_AddressCountry + "\"," +
                "\"" + KeyMapper.epp_PrimaryAddressFlag.getName() + "\"=\"" + epp_PrimaryAddressFlag + "\"," +
                "\"" + KeyMapper.epp_PreferredAddressflag.getName() + "\"=\"" + epp_PreferredAddressflag + "\"," +
                "\"" + KeyMapper.epp_Email.getName() + "\"=\"" + epp_Email + "\"," +
                "\"" + KeyMapper.epp_PrimaryEmail.getName() + "\"=\"" + epp_PrimaryEmail + "\"," +
                "\"" + KeyMapper.epp_preferredemailflag.getName() + "\"=\"" + epp_preferredemailflag + "\"," +
                "\"" + KeyMapper.epp_PhoneAreaCode.getName() + "\"=\"" + epp_PhoneAreaCode + "\"," +
                "\"" + KeyMapper.epp_PhoneCountryCode.getName() + "\"=\"" + epp_PhoneCountryCode + "\"," +
                "\"" + KeyMapper.epp_PhoneNumber.getName() + "\"=\"" + epp_PhoneNumber + "\"," +
                "\"" + KeyMapper.epp_PhoneExt.getName() + "\"=\"" + epp_PhoneExt + "\"," +
                "\"" + KeyMapper.epp_PrimaryPhone.getName() + "\"=\"" + epp_PrimaryPhone + "\"," +
                "\"" + KeyMapper.epp_preferredphoneflag.getName() + "\"=\"" + epp_preferredphoneflag + "\"," +
                "\"" + KeyMapper.epp_DocumentName.getName() + "\"=\"" + epp_DocumentName + "\"," +
                "\"" + KeyMapper.epp_FirstName.getName() + "\"=\"" + epp_FirstName + "\"," +
                "\"" + KeyMapper.epp_MiddleName.getName() + "\"=\"" + epp_MiddleName + "\"," +
                "\"" + KeyMapper.epp_LastName.getName() + "\"=\"" + epp_LastName + "\"," +
                "\"" + KeyMapper.epp_NameSuffix.getName() + "\"=\"" + epp_NameSuffix + "\"," +
                "\"" + KeyMapper.epp_PreferredFirstName.getName() + "\"=\"" + epp_PreferredFirstName + "\"," +
                "\"" + KeyMapper.epp_GenderName.getName() + "\"=\"" + epp_GenderName + "\"," +
                "\"" + KeyMapper.epp_BirthDate.getName() + "\"=\"" + epp_BirthDate + "\"," +
                "\"" + KeyMapper.epp_DeathDate.getName() + "\"=\"" + epp_DeathDate + "\"," +
                "\"" + KeyMapper.epp_DeceasedIndicator.getName() + "\"=\"" + epp_DeceasedIndicator + "\"," +
                "\"" + KeyMapper.epp_MaritalStatusIdName.getName() + "\"=\"" + epp_MaritalStatusIdName + "\"," +
                "\"" + KeyMapper.epp_RaceName.getName() + "\"=\"" + epp_RaceName + "\"," +
                "\"" + KeyMapper.epp_RaceEthnicityIdName.getName() + "\"=\"" + epp_RaceEthnicityIdName + "\"," +
                "\"" + KeyMapper.epp_PreferredLanguageOnlineIdName.getName() + "\"=\"" +
                epp_PreferredLanguageOnlineIdName + "\"," +
                "\"" + KeyMapper.epp_PreferredLanguageSpokenName.getName() + "\"=\"" +
                epp_PreferredLanguageSpokenName + "\"," +
                "\"" + KeyMapper.epp_PreferredLanguageWrittenName.getName() + "\"=\"" +
                epp_PreferredLanguageWrittenName + "\"," +
                "\"" + KeyMapper.epp_DoNotCall.getName() + "\"=\"" + epp_DoNotCall + "\"," +
                "\"" + KeyMapper.epp_DoNotEmail.getName() + "\"=\"" + epp_DoNotEmail + "\"," +
                "\"" + KeyMapper.epp_DoNotMail.getName() + "\"=\"" + epp_DoNotMail + "\"," +
                "\"" + KeyMapper.epp_DoNotSMS.getName() + "\"=\"" + epp_DoNotSMS + "\"," +
                "\"" + KeyMapper.epp_BrokeredIndicator.getName() + "\"=\"" + epp_BrokeredIndicator + "\"," +
                "\"" + KeyMapper.epp_BrokerId.getName() + "\"=\"" + epp_BrokerId + "\"," +
                "\"" + KeyMapper.epp_CIMPMembershipKey.getName() + "\"=\"" + epp_CIMPMembershipKey + "\"," +
                "\"" + KeyMapper.epp_GrandfatheredPlan.getName() + "\"=\"" + epp_GrandfatheredPlan + "\"," +
                "\"" + KeyMapper.epp_KPMedicareMember.getName() + "\"=\"" + epp_KPMedicareMember + "\"," +
                "\"" + KeyMapper.epp_MedicaidIndicator.getName() + "\"=\"" + epp_MedicaidIndicator + "\"," +
                "\"" + KeyMapper.epp_MedicareEligByDisability.getName() + "\"=\"" + epp_MedicareEligByDisability +
                "\"," +
                "\"" + KeyMapper.epp_TobaccoUseIndicator.getName() + "\"=\"" + epp_TobaccoUseIndicator + "\"," +
                "\"" + KeyMapper.epp_SourceSystemIdentifierName.getName() + "\"=\"" + epp_SourceSystemIdentifierName
                + "\"," +
                "\"" + KeyMapper.epp_SourceSystemIdentifierKey.getName() + "\"=\"" + epp_SourceSystemIdentifierKey +
                "\"," +
                "\"" + KeyMapper.epp_SourceSystemIdentifierPrefix.getName() + "\"=\"" +
                epp_SourceSystemIdentifierPrefix + "\"," +
                "\"" + KeyMapper.epp_SourceSystemIdentifierRegionCode.getName() + "\"=\"" +
                epp_SourceSystemIdentifierRegionCode + '\"';
    }

    @Override
    public String toString() {
        return epp_PersonRole + "   " +
                "epp_MemberContractOptionBenefitKey=" + epp_MemberContractOptionBenefitKey +
                ",epp_ContractOptionKey=" + epp_ContractOptionKey +
                ",epp_GroupNo=" + epp_GroupNo +
                ",epp_SubGroupNo=" + epp_SubGroupNo +
                ",epp_PlanId=" + epp_PlanId +
                ",epp_PlanName=" + epp_PlanName +
                ",epp_ProductShortName=" + epp_ProductShortName +
                ",epp_Deductible=" + epp_Deductible +
                ",epp_OutOfPocketMax=" + epp_OutOfPocketMax +
                ",epp_CoPayPCPVisit=" + epp_CoPayPCPVisit +
                ",epp_CoPayLabs=" + epp_CoPayLabs +
                ",epp_CoPayRadiology=" + epp_CoPayRadiology +
                ",epp_effectivefromdate=" + epp_effectivefromdate +
                ",epp_effectivetilldate=" + epp_effectivetilldate +
                ",epp_MembershipContractStartDate=" + epp_MembershipContractStartDate +
                ",epp_MembershipContractEndDate=" + epp_MembershipContractEndDate +
                ",epp_ContractEffectiveStartDate=" + epp_ContractEffectiveStartDate +
                ",epp_ContractEffectiveEndDate=" + epp_ContractEffectiveEndDate +
                ",epp_CommunicationTypeName=" + epp_CommunicationTypeName +
                ",epp_CommunicationSubTypeName=" + epp_CommunicationSubTypeName +
                ",epp_CommunicationChannelTypeName=" + epp_CommunicationChannelTypeName +
                ",epp_ContactMethodType=" + epp_ContactMethodType +
                ",epp_AddressType=" + epp_AddressType +
                ",epp_EmailType=" + epp_EmailType +
                ",epp_PhoneType=" + epp_PhoneType +
                ",epp_AddressLine1=" + epp_AddressLine1 +
                ",epp_AddressLine2=" + epp_AddressLine2 +
                ",epp_AddressLIne3=" + epp_AddressLIne3 +
                ",epp_AddressCity=" + epp_AddressCity +
                ",epp_ContactMethodStateIdName=" + epp_ContactMethodStateIdName +
                ",epp_AddressState=" + epp_AddressState +
                ",epp_AddressZip=" + epp_AddressZip +
                ",epp_AddressZip4=" + epp_AddressZip4 +
                ",epp_AddressCounty=" + epp_AddressCounty +
                ",epp_AddressCountry=" + epp_AddressCountry +
                ",epp_PrimaryAddressFlag=" + epp_PrimaryAddressFlag +
                ",epp_PreferredAddressflag=" + epp_PreferredAddressflag +
                ",epp_Email=" + epp_Email +
                ",epp_PrimaryEmail=" + epp_PrimaryEmail +
                ",epp_preferredemailflag=" + epp_preferredemailflag +
                ",epp_PhoneAreaCode=" + epp_PhoneAreaCode +
                ",epp_PhoneCountryCode=" + epp_PhoneCountryCode +
                ",epp_PhoneNumber=" + epp_PhoneNumber +
                ",epp_PhoneExt=" + epp_PhoneExt +
                ",epp_PrimaryPhone=" + epp_PrimaryPhone +
                ",epp_preferredphoneflag=" + epp_preferredphoneflag +
                ",epp_DocumentName=" + epp_DocumentName +
                ",epp_FirstName=" + epp_FirstName +
                ",epp_MiddleName=" + epp_MiddleName +
                ",epp_LastName=" + epp_LastName +
                ",epp_NameSuffix=" + epp_NameSuffix +
                ",epp_PreferredFirstName=" + epp_PreferredFirstName +
                ",epp_GenderName=" + epp_GenderName +
                ",epp_BirthDate=" + epp_BirthDate +
                ",epp_DeathDate=" + epp_DeathDate +
                ",epp_DeceasedIndicator=" + epp_DeceasedIndicator +
                ",epp_MaritalStatusIdName=" + epp_MaritalStatusIdName +
                ",epp_RaceName=" + epp_RaceName +
                ",epp_RaceEthnicityIdName=" + epp_RaceEthnicityIdName +
                ",epp_PreferredLanguageOnlineIdName=" + epp_PreferredLanguageOnlineIdName +
                ",epp_PreferredLanguageSpokenName=" + epp_PreferredLanguageSpokenName +
                ",epp_PreferredLanguageWrittenName=" + epp_PreferredLanguageWrittenName +
                ",epp_DoNotCall=" + epp_DoNotCall +
                ",epp_DoNotEmail=" + epp_DoNotEmail +
                ",epp_DoNotMail=" + epp_DoNotMail +
                ",epp_DoNotSMS=" + epp_DoNotSMS +
                ",epp_BrokeredIndicator=" + epp_BrokeredIndicator +
                ",epp_BrokerId=" + epp_BrokerId +
                ",epp_CIMPMembershipKey=" + epp_CIMPMembershipKey +
                ",epp_GrandfatheredPlan=" + epp_GrandfatheredPlan +
                ",epp_KPMedicareMember=" + epp_KPMedicareMember +
                ",epp_MedicaidIndicator=" + epp_MedicaidIndicator +
                ",epp_MedicareEligByDisability=" + epp_MedicareEligByDisability +
                ",epp_TobaccoUseIndicator=" + epp_TobaccoUseIndicator +
                ",epp_SourceSystemIdentifierName=" + epp_SourceSystemIdentifierName +
                ",epp_SourceSystemIdentifierKey=" + epp_SourceSystemIdentifierKey +
                ",epp_SourceSystemIdentifierPrefix=" + epp_SourceSystemIdentifierPrefix +
                ",epp_SourceSystemIdentifierRegionCode=" + epp_SourceSystemIdentifierRegionCode;
    }
}

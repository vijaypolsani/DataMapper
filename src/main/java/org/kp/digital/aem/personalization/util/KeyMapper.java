package org.kp.digital.aem.personalization.util;

/**
 * Created by vijay on 11/11/15.
 */
public enum KeyMapper {
    //Excel header based Simple Obfuscation
    epp_PersonRole("A"),
    epp_MemberContractOptionBenefitKey("B"),
    epp_ContractOptionKey("C"),
    epp_GroupNo("D"),
    epp_SubGroupNo("E"),
    epp_PlanId("F"),
    epp_PlanName("G"),
    epp_ProductShortName("H"),
    epp_Deductible("I"),
    epp_OutOfPocketMax("J"),
    epp_CoPayPCPVisit("K"),
    epp_CoPayLabs("L"),
    epp_CoPayRadiology("M"),
    epp_effectivefromdate("N"),
    epp_effectivetilldate("O"),
    epp_MembershipContractStartDate("P"),
    epp_MembershipContractEndDate("Q"),
    epp_ContractEffectiveStartDate("R"),
    epp_ContractEffectiveEndDate("S"),
    epp_CommunicationTypeName("T"),
    epp_CommunicationSubTypeName("U"),
    epp_CommunicationChannelTypeName("V"),
    epp_ContactMethodType("W"),
    epp_AddressType("X"),
    epp_EmailType("Y"),
    epp_PhoneType("Z"),
    epp_AddressLine1("AA"),
    epp_AddressLine2("AB"),
    epp_AddressLIne3("AC"),
    epp_AddressCity("AD"),
    epp_ContactMethodStateIdName("AE"),
    epp_AddressState("AF"),
    epp_AddressZip("AG"),
    epp_AddressZip4("AH"),
    epp_AddressCounty("AI"),
    epp_AddressCountry("AJ"),
    epp_PrimaryAddressFlag("AK"),
    epp_PreferredAddressflag("AL"),
    epp_Email("AM"),
    epp_PrimaryEmail("AN"),
    epp_preferredemailflag("AO"),
    epp_PhoneAreaCode("AP"),
    epp_PhoneCountryCode("AQ"),
    epp_PhoneNumber("AR"),
    epp_PhoneExt("AS"),
    epp_PrimaryPhone("AT"),
    epp_preferredphoneflag("AU"),
    epp_DocumentName("AV"),
    epp_FirstName("AW"),
    epp_MiddleName("AX"),
    epp_LastName("AY"),
    epp_NameSuffix("AZ"),
    epp_PreferredFirstName("BA"),
    epp_GenderName("BB"),
    epp_BirthDate("BC"),
    epp_DeathDate("BD"),
    epp_DeceasedIndicator("BE"),
    epp_MaritalStatusIdName("BF"),
    epp_RaceName("BG"),
    epp_RaceEthnicityIdName("BH"),
    epp_PreferredLanguageOnlineIdName("BI"),
    epp_PreferredLanguageSpokenName("BJ"),
    epp_PreferredLanguageWrittenName("BK"),
    epp_DoNotCall("BL"),
    epp_DoNotEmail("BM"),
    epp_DoNotMail("BN"),
    epp_DoNotSMS("BO"),
    epp_BrokeredIndicator("BP"),
    epp_BrokerId("BQ"),
    epp_CIMPMembershipKey("BR"),
    epp_GrandfatheredPlan("BS"),
    epp_KPMedicareMember("BT"),
    epp_MedicaidIndicator("BU"),
    epp_MedicareEligByDisability("BV"),
    epp_TobaccoUseIndicator("BW"),
    epp_SourceSystemIdentifierName("BX"),
    epp_SourceSystemIdentifierKey("BY"),
    epp_SourceSystemIdentifierPrefix("BZ"),
    epp_SourceSystemIdentifierRegionCode("CA");

    private String value;

    KeyMapper(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}


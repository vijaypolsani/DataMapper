package org.kp.digital.aem.personalization.util;

/**
 * Created by vijay on 11/11/15.
 */
public enum KeyMapper {
    //Excel header based Simple Obfuscation
    epp_PersonRole("a"),
    epp_MemberContractOptionBenefitKey("b"),
    epp_ContractOptionKey("c"),
    epp_GroupNo("d"),
    epp_SubGroupNo("e"),
    epp_PlanId("f"),
    epp_PlanName("g"),
    epp_ProductShortName("h"),
    epp_Deductible("i"),
    epp_OutOfPocketMax("j"),
    epp_CoPayPCPVisit("k"),
    epp_CoPayLabs("l"),
    epp_CoPayRadiology("m"),
    epp_effectivefromdate("n"),
    epp_effectivetilldate("o"),
    epp_MembershipContractStartDate("p"),
    epp_MembershipContractEndDate("q"),
    epp_ContractEffectiveStartDate("r"),
    epp_ContractEffectiveEndDate("s"),
    epp_CommunicationTypeName("t"),
    epp_CommunicationSubTypeName("u"),
    epp_CommunicationChannelTypeName("v"),
    epp_ContactMethodType("w"),
    epp_AddressType("x"),
    epp_EmailType("y"),
    epp_PhoneType("z"),
    epp_AddressLine1("aa"),
    epp_AddressLine2("ab"),
    epp_AddressLIne3("ac"),
    epp_AddressCity("ad"),
    epp_ContactMethodStateIdName("ae"),
    epp_AddressState("af"),
    epp_AddressZip("ag"),
    epp_AddressZip4("ah"),
    epp_AddressCounty("ai"),
    epp_AddressCountry("aj"),
    epp_PrimaryAddressFlag("ak"),
    epp_PreferredAddressflag("al"),
    epp_Email("am"),
    epp_PrimaryEmail("an"),
    epp_preferredemailflag("ao"),
    epp_PhoneAreaCode("ap"),
    epp_PhoneCountryCode("aq"),
    epp_PhoneNumber("ar"),
    epp_PhoneExt("as"),
    epp_PrimaryPhone("at"),
    epp_preferredphoneflag("au"),
    epp_DocumentName("av"),
    epp_FirstName("aw"),
    epp_MiddleName("ax"),
    epp_LastName("ay"),
    epp_NameSuffix("az"),
    epp_PreferredFirstName("ba"),
    epp_GenderName("bb"),
    epp_BirthDate("bc"),
    epp_DeathDate("bd"),
    epp_DeceasedIndicator("be"),
    epp_MaritalStatusIdName("bf"),
    epp_RaceName("bg"),
    epp_RaceEthnicityIdName("bh"),
    epp_PreferredLanguageOnlineIdName("bi"),
    epp_PreferredLanguageSpokenName("bj"),
    epp_PreferredLanguageWrittenName("bk"),
    epp_DoNotCall("bl"),
    epp_DoNotEmail("bm"),
    epp_DoNotMail("bn"),
    epp_DoNotSMS("bo"),
    epp_BrokeredIndicator("bp"),
    epp_BrokerId("bq"),
    epp_CIMPMembershipKey("br"),
    epp_GrandfatheredPlan("bs"),
    epp_KPMedicareMember("bt"),
    epp_MedicaidIndicator("bu"),
    epp_MedicareEligByDisability("bv"),
    epp_TobaccoUseIndicator("bw"),
    epp_SourceSystemIdentifierName("bx"),
    epp_SourceSystemIdentifierKey("by"),
    epp_SourceSystemIdentifierPrefix("bz"),
    epp_SourceSystemIdentifierRegionCode("ca");

    private String value;

    KeyMapper(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}


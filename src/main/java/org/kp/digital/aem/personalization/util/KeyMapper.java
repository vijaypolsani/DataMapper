package org.kp.digital.aem.personalization.util;

/**
 * Created by vijay on 11/11/15.
 */
public enum KeyMapper {
    //Excel header based Simple Obfuscation
    //Person
    epp_PersonRole("a"),
    epp_KPGUID("b"),
    epp_MRN("c"),
    epp_MRNRegion("d"),
    epp_MRNPrefix("e"),
    epp_FirstName("f"),
    epp_MiddleName("g"),
    epp_LastName("h"),
    epp_NameSuffix("i"),
    epp_PreferredFirstName("j"),
    epp_GenderName("k"),
    epp_BirthDate("l"),
    epp_DeathDate("m"),
    epp_DeceasedIndicator("n"),
    epp_MaritalStatusIdName("o"),
    epp_RaceName("p"),
    epp_RaceEthnicityIdName("q"),
    epp_PreferredLanguageOnlineIdName("r"),
    epp_PreferredLanguageSpokenName("s"),
    epp_PreferredLanguageWrittenName("t"),
    epp_DoNotCall("u"),
    epp_DoNotEmail("v"),
    epp_DoNotMail("w"),
    epp_DoNotSMS("x"),
    epp_BrokeredIndicator("y"),
    epp_BrokerId("z"),
    epp_CIMPMembershipKey("aa"),
    epp_GrandfatheredPlan("ab"),
    epp_KPMedicareMember("ac"),
    epp_MedicaidIndicator("ad"),
    epp_MedicareEligByDisability("ae"),
    epp_TobaccoUseIndicator("af"),
    epp_MembershipStartDate("ag"),
    epp_PriorMembershipEndDate("ah"),
    epp_NewIdentifier("ai"),
    //Contact Methods
    epp_ContactMethodType("aj"),
    epp_AddressType("ak"),
    epp_EmailType("al"),
    epp_PhoneType("am"),
    epp_AddressLine1("an"),
    epp_AddressLine2("ao"),
    epp_AddressLIne3("ap"),
    epp_AddressCity("aq"),
    epp_ContactMethodStateIdName("ar"),
    epp_AddressState("as"),
    epp_AddressZip("at"),
    epp_AddressZip4("au"),
    epp_AddressCounty("av"),
    epp_AddressCountry("aw"),
    epp_PrimaryAddressFlag("ax"),
    epp_PreferredAddressflag("ay"),
    epp_Email("az"),
    epp_PrimaryEmail("ba"),
    epp_preferredemailflag("bb"),
    epp_PhoneAreaCode("bc"),
    epp_PhoneCountryCode("bd"),
    epp_PhoneNumber("be"),
    epp_PhoneExt("bf"),
    epp_PrimaryPhone("bg"),
    epp_preferredphoneflag("bh"),
    //Comunication Preferences
    epp_CommunicationTypeName("bi"),
    epp_CommunicationSubTypeName("bj"),
    epp_com_CommunicationChannelTypeName("bk"),
    //Document Preferences
    epp_DocumentName("bl"),
    epp_doc_CommunicationChannelTypeName("bm");


    private String value;

    KeyMapper(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}


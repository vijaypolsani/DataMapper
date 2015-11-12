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
public class EppBenefits {

    //@DatabaseField(id = true)
    //private long sequenceNumber;
    @Parsed
    @DatabaseField(id = true)
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

    public EppBenefits() {
        // ORMLite needs a no-arg constructor
    }

}

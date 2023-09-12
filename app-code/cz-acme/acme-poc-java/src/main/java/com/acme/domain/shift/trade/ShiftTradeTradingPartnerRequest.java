package com.acme.domain.shift.trade;

import java.util.List;
import java.util.Objects;

public class ShiftTradeTradingPartnerRequest {
    private List<Integer> shiftIdList;

    private Boolean leaderOverride;
    private Boolean trading;

    private String benefitTypeCode;
    private String recipientPerner;
    private String approvingLeader;

    public ShiftTradeTradingPartnerRequest() {
    }

    public ShiftTradeTradingPartnerRequest(List<Integer> shiftIdList, Boolean leaderOverride, Boolean trading, String benefitTypeCode, String recipientPerner, String approvingLeader) {
        this.shiftIdList = shiftIdList;
        this.leaderOverride = leaderOverride;
        this.trading = trading;
        this.benefitTypeCode = benefitTypeCode;
        this.recipientPerner = recipientPerner;
        this.approvingLeader = approvingLeader;
    }

    public List<Integer> getShiftIdList() {
        return shiftIdList;
    }

    public void setShiftIdList(List<Integer> shiftIdList) {
        this.shiftIdList = shiftIdList;
    }

    public Boolean getLeaderOverride() {
        return leaderOverride;
    }

    public void setLeaderOverride(Boolean leaderOverride) {
        this.leaderOverride = leaderOverride;
    }

    public Boolean getTrading() {
        return trading;
    }

    public void setTrading(Boolean trading) {
        this.trading = trading;
    }

    public String getBenefitTypeCode() {
        return benefitTypeCode;
    }

    public void setBenefitTypeCode(String benefitTypeCode) {
        this.benefitTypeCode = benefitTypeCode;
    }

    public String getRecipientPerner() {
        return recipientPerner;
    }

    public void setRecipientPerner(String recipientPerner) {
        this.recipientPerner = recipientPerner;
    }

    public String getApprovingLeader() {
        return approvingLeader;
    }

    public void setApprovingLeader(String approvingLeader) {
        this.approvingLeader = approvingLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftTradeTradingPartnerRequest that = (ShiftTradeTradingPartnerRequest) o;
        return Objects.equals(shiftIdList, that.shiftIdList) && Objects.equals(leaderOverride, that.leaderOverride) && Objects.equals(trading, that.trading) && Objects.equals(benefitTypeCode, that.benefitTypeCode) && Objects.equals(recipientPerner, that.recipientPerner) && Objects.equals(approvingLeader, that.approvingLeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiftIdList, leaderOverride, trading, benefitTypeCode, recipientPerner, approvingLeader);
    }

    @Override
    public String toString() {
        return "ShiftTradeTradingPartnerRequest{" +
            "shiftIdList=" + shiftIdList +
            ", leaderOverride=" + leaderOverride +
            ", trading=" + trading +
            ", benefitTypeCode='" + benefitTypeCode + '\'' +
            ", recipientPerner='" + recipientPerner + '\'' +
            ", approvingLeader='" + approvingLeader + '\'' +
            '}';
    }

    public static ShiftTradeTradingPartnerRequestBuilder tradingPartnerRequestBuilder() {
        return new ShiftTradeTradingPartnerRequestBuilder();
    }

    public static class ShiftTradeTradingPartnerRequestBuilder {
        protected List<Integer> shiftIdList;

        protected Boolean leaderOverride;
        protected Boolean trading;

        protected String benefitTypeCode;
        protected String recipientPerner;
        protected String approvingLeader;

        public ShiftTradeTradingPartnerRequestBuilder shiftIdList(List<Integer> shiftIdList) {
            this.shiftIdList = shiftIdList;
            return this;
        }

        public ShiftTradeTradingPartnerRequestBuilder leaderOverride(Boolean leaderOverride) {
            this.leaderOverride = leaderOverride;
            return this;
        }

        public ShiftTradeTradingPartnerRequestBuilder trading(Boolean trading) {
            this.trading = trading;
            return this;
        }

        public ShiftTradeTradingPartnerRequestBuilder benefitTypeCode(String benefitTypeCode) {
            this.benefitTypeCode = benefitTypeCode;
            return this;
        }

        public ShiftTradeTradingPartnerRequestBuilder recipientPerner(String recipientPerner) {
            this.recipientPerner = recipientPerner;
            return this;
        }

        public ShiftTradeTradingPartnerRequestBuilder approvingLeader(String approvingLeader) {
            this.approvingLeader = approvingLeader;
            return this;
        }

        public ShiftTradeTradingPartnerRequest build() {
            return new ShiftTradeTradingPartnerRequest(shiftIdList, leaderOverride, trading, benefitTypeCode, recipientPerner, approvingLeader);
        }
    }
}

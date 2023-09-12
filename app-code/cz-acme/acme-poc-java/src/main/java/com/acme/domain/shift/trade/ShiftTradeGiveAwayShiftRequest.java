package com.acme.domain.shift.trade;

import java.util.List;

//extends ShiftTradeTradingPartnerRequest
public class ShiftTradeGiveAwayShiftRequest extends ShiftTradeTradingPartnerRequest {
    public ShiftTradeGiveAwayShiftRequest() {
    }

    ShiftTradeGiveAwayShiftRequest(List<Integer> shiftIdList, Boolean leaderOverride, Boolean trading, String benefitTypeCode, String recipientPerner, String approvingLeader) {
        super(shiftIdList, leaderOverride, trading, benefitTypeCode, recipientPerner, approvingLeader);
    }

    @Override
    public String toString() {
        return "ShiftTradeGiveAwayShiftRequest{" +
            "shiftIdList=" + getShiftIdList() +
            ", leaderOverride=" + getLeaderOverride() +
            ", trading=" + getTrading() +
            ", benefitTypeCode='" + getBenefitTypeCode() + '\'' +
            ", recipientPerner='" + getRecipientPerner() + '\'' +
            ", approvingLeader='" + getApprovingLeader() + '\'' +
            "} ";
    }

    public static ShiftTradeGiveAwayShiftRequestBuilder giveAwayShiftRequestBuilder() {
        return new ShiftTradeGiveAwayShiftRequestBuilder();
    }

    public static class ShiftTradeGiveAwayShiftRequestBuilder extends ShiftTradeTradingPartnerRequestBuilder {
        public ShiftTradeGiveAwayShiftRequestBuilder() {
            super();
        }

        public ShiftTradeGiveAwayShiftRequest build() {
            return new ShiftTradeGiveAwayShiftRequest(shiftIdList, leaderOverride, trading, benefitTypeCode, recipientPerner, approvingLeader);
        }
    }
}
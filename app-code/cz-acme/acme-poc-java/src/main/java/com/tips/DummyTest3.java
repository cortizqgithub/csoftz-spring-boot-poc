/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.tips;

import com.acme.domain.shift.trade.ShiftTradeGiveAwayShiftRequest;
import com.acme.domain.shift.trade.ShiftTradeTradingPartnerRequest;

public class DummyTest3 {
    public static void main(String[] args) {
        var kk = new ShiftTradeTradingPartnerRequest();
        var k1 = new ShiftTradeGiveAwayShiftRequest();

        System.out.println("KK ->");
        System.out.println(kk);
        System.out.println("K1-->");
        System.out.println(k1);


        var k2 = ShiftTradeGiveAwayShiftRequest.giveAwayShiftRequestBuilder().trading(false).build();
        var k3 = ShiftTradeTradingPartnerRequest.tradingPartnerRequestBuilder().trading(false).build();

        System.out.println("K2-->");
        System.out.println(k2);
        System.out.println("K3 -->");
        System.out.println(k3);
    }
}

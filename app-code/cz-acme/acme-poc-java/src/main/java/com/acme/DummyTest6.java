/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme;

import java.util.List;

public class DummyTest6 {
    public static void main(String[] args) {
        var locales = List.of("en", "es", "ht");

        System.out.println("EN " + locales.contains("EN"));

        String str = "x_wdtpa_wdpr_hub_m.csv";
        String[] arrOfStr = str.split("\\.");

        for (String a : arrOfStr)
            System.out.println(a);
    }
}

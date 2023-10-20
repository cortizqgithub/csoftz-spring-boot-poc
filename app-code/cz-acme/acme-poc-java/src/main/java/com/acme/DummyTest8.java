/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class DummyTest8 {
    public static void main(String[] args) {
        var s = "  cArLoS oRtIz  ";
        var s1 = " ortic140 ";
        var s3 = " 012354 ";

        var s4 = WordUtils.capitalize(s);
        System.out.println("s4["+s4+"]");
        String capitalize = StringUtils.capitalize(s);
        System.out.println("["+capitalize.trim()+"]");
        String upperCase = s1.toUpperCase();
        System.out.println("["+upperCase.trim()+"]");
        String s31 = s3;
        System.out.println("["+s31.trim()+"]");


        var capitalizeWords = WordUtils.capitalize(s.trim().toLowerCase());
        System.out.println(capitalizeWords);
        System.out.println("s [" + s + "]");
    }

}

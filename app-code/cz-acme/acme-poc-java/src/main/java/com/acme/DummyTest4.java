/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class DummyTest4 {
    public static void main(String[] args) {
        Optional<String> st = Optional.ofNullable(null);
        String pernr = "123";

        System.out.println(StringUtils.isNotEmpty(null));

        st.ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("LOG " + pernr));
    }
}

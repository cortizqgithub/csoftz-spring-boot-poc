/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.tips;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class DummyTest7 {
    public static void main(String[] args) {
        var s = "<SCRIPT></script>";
        var s1 = "<style>";

        var b = s.toLowerCase().contains("<script");
        var b1 = s1.toLowerCase().contains("<script");
        System.out.println(b);
        System.out.println(b1);

        var list = List.of("<script", "<style");

        var b2 = hasMatchingSubstring("The long <script ", list);

        System.out.println(" THis b2 " + b2);

        System.out.println("=========");
        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(CollectionUtils.isEmpty(null));
        System.out.println(CollectionUtils.isEmpty(List.of()));
    }

    private static boolean hasMatchingSubstring(String str, List<String> substrings) {
        return substrings.stream().anyMatch(str::contains);
    }
}

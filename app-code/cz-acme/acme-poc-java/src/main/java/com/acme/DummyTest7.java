/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme;

import java.util.List;

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


    }

    private static boolean hasMatchingSubstring(String str, List<String> substrings) {
        return substrings.stream().anyMatch(str::contains);
    }
}

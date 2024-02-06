/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme;

import java.util.List;
import java.util.stream.Collectors;

public class DummyTest9 {
    public static void main(String[] args) {
        var longs = convertToLongList(List.of("1d23", "456"));
        System.out.println(longs);
    }

    private static List<Long> convertToLongList(List<String> strings) {
        return strings.stream().map(Long::valueOf).collect(Collectors.toList());
    }
}

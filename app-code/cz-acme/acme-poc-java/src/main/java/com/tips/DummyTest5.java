/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.tips;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DummyTest5 {

    public static void main(String[] args) {
        var hmap = new HashMap<String, String>();

        hmap.put("en", "Apple");
        hmap.put("En", "Orange");
        hmap.put("EN", "Kiwi");
        hmap.put("eN", "Banana");
        hmap.put("null", "Banana");
        hmap.put("Null", "Banana");
        hmap.put("NuLl", "Banana");
        hmap.put("NULL", "Banana");
        hmap.put(" null", "empty2");
        hmap.put("  null  ", "empty2");
        hmap.put("pepito", "Nice name");
        hmap.put("   pepito  ", "Nice name");
        hmap.put("", "empty");
        hmap.put("           ", "empty2");
        hmap.put("es", "FRist Espanish");

        var mySet = new HashSet<String>();

        mySet.add("Null");
        mySet.add("null");
        mySet.add("null");
        mySet.add("nulla");

        countKey("en", hmap);
        countKey("null", hmap);
        countKey("", hmap);
        countKey("es", hmap);
        countKey("ht", hmap);
        countKey("pepito", hmap);
        countKey("pt", hmap);


        String languages = "   en,                 es                              , ht                        ";


        var mm = languages.split(",");
        var validLanguageKeys = List.of(mm).stream().map(s -> s.trim()).collect(Collectors.toList());
        System.out.println("validLanguageKeys=> " + validLanguageKeys);


        var keys = hmap.keySet();

        System.out.println("KEYS to Work=" + keys);
        var collecting = keys.stream().map(key -> key.trim()).map(key -> key.toLowerCase(Locale.getDefault())).collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
        System.out.println(collecting);

        var keysChecked = collecting.keySet();

        System.out.println("PT Contained " + keysChecked.contains("pt"));
        System.out.println("EN Contained " + keysChecked.contains("en"));
        System.out.println("<empty> Contained " + keysChecked.contains(""));


        var counter = 0L;

        if (keysChecked.contains("es")) {
            counter = collecting.get("es");
            if (counter > 1) {
                System.out.println("=====> Key [es] has more than one entry defined.");
            }
        }

        if (keysChecked.contains("en")) {
            counter = collecting.get("en");
            if (counter > 1) {
                System.out.println("=====> Key [en] has more than one entry defined.");
            }
        }

        if (keysChecked.contains("")) {
            counter = collecting.get("");
            if (counter >= 0) {
                System.out.println("=====> Empty keys are not allowed.");
            }
        }


        // ---------------------------------------------------------------------------------------

        System.out.println("===============================================================================");
        if (!collecting.keySet().contains("en")) {
            System.out.println("EN key is mandatory to be present in 'localeData'.");
        }
        System.out.println("////");

        collecting.forEach((k, v) -> {
            if (!validLanguageKeys.contains(k)) {
                var isNullOrEmptyKey = "".equals(k) || "null".equals(k);

                System.out.println("Key [" + ("".equals(k) ? "EMPTY" : k) + "] in 'localeData' is not supported as valid language key. List of supported language keys are " + validLanguageKeys + ".");

                if (isNullOrEmptyKey) {
                    if (v >= 0) {
                        System.out.println("Key [" + ("".equals(k) ? "EMPTY" : k) + "] in 'localeData' has more than one value defined.");
                    }
                } else {
                    if (v > 1) {
                        System.out.println("AAAA Key [" + k + "] in 'localeData' has more than one value defined.");
                    }
                }
            } else {
                if (v > 1) {
                    System.out.println("Supported key [" + k + "] in 'localeData' has more than one value defined.");
                }
            }
        });
    }

    private static Boolean countKey(String keyValue, Map<String, String> hmap) {
        var itemCnt = hmap.keySet()
            .stream()
            .map(key -> key.trim())
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .filter(key -> key.equals(keyValue))
            .count();

        System.out.println("Key used[" + keyValue + "] with " + itemCnt + " times.");

        return itemCnt == 0L;
    }

    private static Boolean countKey1(String keyValue, Map<String, String> hmap) {
        var itemCnt = hmap.keySet()
            .stream()
            .map(key -> key.trim())
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .filter(key -> key.equals(keyValue))
            .count();

        System.out.println("Key used[" + keyValue + "] with " + itemCnt + " times.");

        return itemCnt == 0L;
    }

}

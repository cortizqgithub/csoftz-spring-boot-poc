/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme.controller.api.v2;

import com.acme.domain.custom.card.request.CustomCardRequest;
import com.acme.service.LanguageKeyValidatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/custom-cards")
public record CustomCardV2Controller(LanguageKeyValidatorService languageKeyValidatorService) {

    @PostMapping
    public List<String> validateLanguageKeys(@RequestBody CustomCardRequest request) {

      /*  var s = validLanguageKeys.toString();
        var existENKey = countKey(defaultLanguage, request.getLocaleData().keySet());
        var existNullKey = countKey("null", request.getLocaleData().keySet());
        var existEmptyKey = countKey("", request.getLocaleData().keySet());

       */


        // now the items in list

        var keys = request.getLocaleData().keySet();
        var trimmedKeysCount = keys.stream()
            .map(key -> key.trim())
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        var keyList = keys.stream().toList();
        var k = keyList.get(1);

        var countMatch = StringUtils.countMatches(k, " ");
        var countMatch0 = StringUtils.countMatches("en", " ");

        var splitted = k.split(" ");
        var splitted0 = "en".split(" ");


        var getTokesK = getTokens(k);



        var errorsOnKeys =
            languageKeyValidatorService
                .validateErrorsOnKeys(
                    request
                        .getLocaleData()
                        .keySet()
                        .stream()
                        .toList()
                );

        //System.out.println(errorsOnKeys.toString());

        System.out.println(StringUtils.join(errorsOnKeys, "\r\n"));
        return errorsOnKeys;
    }

    public List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    private Boolean countKey(String keyValue, Set<String> keys) {
        return keys
            .stream()
            .map(key -> key.trim())
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .filter(key -> key.equals(keyValue))
            .count() == 0L;
    }

    private Boolean countKey(String keyValue, Map<String, String> hmap) {
        return hmap.keySet()
            .stream()
            .map(key -> key.trim())
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .filter(key -> key.equals(keyValue))
            .count() == 0L;
    }
}

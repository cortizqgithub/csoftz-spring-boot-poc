/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme.service.impl;

import com.acme.service.LanguageKeyValidatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class LanguageKeyValidatorServiceImpl implements LanguageKeyValidatorService {
    private String defaultLanguage = "en";
    private List<String> validLanguageKeys;

    @PostConstruct
    public void postConstruct() {
        String languages = "     en,              pt                         , es                              , ht                        ";
        validLanguageKeys = List.of(languages.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
    }

    @Override
    public List<String> validateErrorsOnKeys(List<String> keys) {

        var errorList = new ArrayList<String>();
        var keyCountMap = keys.stream().map(key -> key.trim()).map(key -> key.toLowerCase(Locale.getDefault())).collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        keys.stream()
            .map(key -> key.toLowerCase(Locale.getDefault()))
            .forEach(key -> {
                var tokens = extractTokens(key);
                var countMatch = StringUtils.countMatches(key, " ");
                var keyTrimmed = key.trim();

                if (countMatch > 0) {
                    errorList.add("Key [" + keyTrimmed + "] must not contain spaces.");
                }

                if (tokens.size() > 1) {
                    errorList.add("Key [" + keyTrimmed + "] contains more than one token.");
                }
            });


        if (!keyCountMap.keySet().contains(defaultLanguage)) {
            errorList.add("EN key is mandatory to be present in 'localeData'.");
        }

        keyCountMap.forEach((k, v) -> {
            if (!validLanguageKeys.contains(k)) {
                var isNullOrEmptyKey = "".equals(k) || "null".equals(k);

                errorList.add("Key [" + ("".equals(k) ? "EMPTY" : k) + "] in 'localeData' is not supported as valid language key. List of supported language keys are " + validLanguageKeys + ".");

                if (isNullOrEmptyKey) {
                    if (v >= 0) {
                        errorList.add("Key [" + ("".equals(k) ? "EMPTY" : k) + "] in 'localeData' has more than one value defined.");
                    }
                } else {
                    if (v > 1) {
                        errorList.add("Key [" + k + "] in 'localeData' has more than one value defined.");
                    }
                }
            } else {
                if (v > 1) {
                    errorList.add("Supported key [" + k + "] in 'localeData' has more than one value defined.");
                }
            }
        });

        return errorList;
    }

    private List<String> extractTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }
}

/* -------------------------------------------- COPYRIGHT NOTICE --------------------------------------------
 * This file contains confidential and proprietary information of The Walt Disney Company.
 * No license or permission is hereby granted to use such information in any manner.
 *
 * (c) Walt Disney.  All rights reserved.
 */
package com.acme.service;

import java.util.List;
import java.util.Map;

public interface LanguageKeyValidatorService {
    List<String> validateErrorsOnKeys(List<String> keys);
}

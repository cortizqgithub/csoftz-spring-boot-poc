/*----------------------------------------------------------------------------*/
/* Source File:   PERSON.JAVA                                                 */
/* Description:   Domain object to represent a Person.                        */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Jul.24/2020                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 Jul.24/2020  COQ  Converted to be immutable.
 -----------------------------------------------------------------------------*/
package com.example.devops.domain;

import lombok.Builder;
import lombok.Value;

/**
 * Domain object to represent a Person.
 * <p><b>NOTE:</b> Converted to be used exclusively as immutable.</p>
 * <br>
 * <p>To achieve immutability we use Lombok <a href="https://projectlombok.org/features/Value">@Value</a> annotation.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 11 (JDK), Mar.01/2019
 */
@Value
@Builder
public class Person {
    String firstName;
    String lastName;
}

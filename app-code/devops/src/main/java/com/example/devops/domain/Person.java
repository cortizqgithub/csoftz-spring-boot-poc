/*----------------------------------------------------------------------------*/
/* Source File:   PERSON.JAVA                                                 */
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
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@Value
@Builder
public class Person {
    String firstName;
    String lastName;
}

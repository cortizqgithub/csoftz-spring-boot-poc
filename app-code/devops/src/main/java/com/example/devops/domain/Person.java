/*----------------------------------------------------------------------------*/
/* Source File:   PERSON.JAVA                                                 */
/* Description:   Domain object to represent a Person.                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Mar.16/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Domain object to represent a Person.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 11 (JDK), Mar.01/2019
 */
@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
}

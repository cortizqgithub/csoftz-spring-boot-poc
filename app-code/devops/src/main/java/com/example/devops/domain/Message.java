/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGE.JAVA                                                */
/* Description:   Domain object to represent a Message.                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Jul.24/2020                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 Jul.24/2020  COQ  Converted to be immutable.
 -----------------------------------------------------------------------------*/
package com.example.devops.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

/**
 * Domain object to represent a Message.
 * <p><b>NOTE:</b> Converted to be used exclusively as immutable.</p>
 * <br>
 * <p>To achieve immutability we use Lombok <a href="https://projectlombok.org/features/Value">@Value</a> annotation.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Jul.24/2020
 * @since 11 (JDK), Mar.01/2019
 */
@Value
@Builder
public class Message {
    LocalDateTime dateTime;
    String msg;
}

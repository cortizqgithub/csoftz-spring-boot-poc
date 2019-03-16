/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGE.JAVA                                                */
/* Description:   Domain object to represent a Message.                       */
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

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Domain object to represent a Message.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 1.8 (JDK), Mar.01/2019
 */
@Data
public class Message {
    private LocalDateTime dateTime;
    private String msg;
}

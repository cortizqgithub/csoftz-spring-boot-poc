/*----------------------------------------------------------------------------*/
/* Source File:   BADREQUESTEXCEPTION.JAVA                                    */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webmvc.common.exception;

public class BadRequestException extends Exception {
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "BadRequestException: " + getMessage();
    }
}

/*----------------------------------------------------------------------------*/
/* Source File:   MyServiceException.java                                     */
/* Copyright (c), 2023 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.10/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.common.exception;

public class MyServiceException extends RuntimeException {
    public MyServiceException(String msg) {
        super(msg);
    }
}

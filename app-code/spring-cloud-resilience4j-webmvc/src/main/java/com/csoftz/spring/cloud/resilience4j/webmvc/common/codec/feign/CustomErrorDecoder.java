/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERRORDECODER.JAVA                                     */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webmvc.common.codec.feign;

import com.csoftz.spring.cloud.resilience4j.webmvc.common.exception.BadRequestException;
import com.csoftz.spring.cloud.resilience4j.webmvc.common.exception.NotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException();
            default:
                return new Exception("Generic error");
        }
    }
}

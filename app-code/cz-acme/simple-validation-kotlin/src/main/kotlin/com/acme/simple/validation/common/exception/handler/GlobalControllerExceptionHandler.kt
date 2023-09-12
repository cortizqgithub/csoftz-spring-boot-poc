package com.acme.simple.validation.common.exception.handler

import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.ERROR_CATEGORY_PARAMETERS
import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.PROPERTY_ERRORS
import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.PROPERTY_ERROR_CATEGORY
import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.PROPERTY_TIMESTAMP
import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.TITLE_BAD_REQUEST_ON_PAYLOAD
import com.acme.simple.validation.common.consts.ControllerExceptionHandlerConstants.TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD
import com.acme.simple.validation.common.consts.GlobalConstants.COLON_SPACE_DELIMITER
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.net.URI
import java.time.Instant
import java.util.stream.*

//@RestControllerAdvice
class GlobalControllerExceptionHandler : ResponseEntityExceptionHandler() {
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val instanceURL = (request as ServletWebRequest).request.requestURI // This cast is for Servlet use case.

        return createResponseEntity(
            ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD)
                .title(TITLE_BAD_REQUEST_ON_PAYLOAD)
                .type(URI.create(instanceURL))
                .instance(URI.create(instanceURL))
                .property(PROPERTY_ERROR_CATEGORY, ERROR_CATEGORY_PARAMETERS)
                .property(PROPERTY_ERRORS,
                          Stream.concat(
                              ex.bindingResult
                                  .fieldErrors
                                  .stream()
                                  .map { field: FieldError -> field.field + COLON_SPACE_DELIMITER + field.defaultMessage },
                              ex.bindingResult
                                  .globalErrors
                                  .stream()
                                  .map { field1: ObjectError -> field1.objectName + COLON_SPACE_DELIMITER + field1.defaultMessage }
                          )
                              .sorted()
                              .toList()
                )
                .property(PROPERTY_TIMESTAMP, Instant.now())
                .build(),
            headers, status, request)
    }
}
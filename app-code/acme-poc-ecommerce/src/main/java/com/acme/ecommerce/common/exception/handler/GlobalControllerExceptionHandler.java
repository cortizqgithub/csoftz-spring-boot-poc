/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONTROLLEREXCEPTIONHANDLER.JAVA                       */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.common.exception.handler;

import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.ERROR_CATEGORY_PARAMETERS;
import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.PROPERTY_ERRORS;
import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.PROPERTY_ERROR_CATEGORY;
import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.PROPERTY_TIMESTAMP;
import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.TITLE_BAD_REQUEST_ON_PAYLOAD;
import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD;
import static com.acme.ecommerce.common.constants.GlobalConstants.COLON_SPACE_DELIMITER;

import com.acme.ecommerce.rs.product.domain.exception.ProductNotFoundException;
import com.acme.ecommerce.rs.product.domain.exception.ProductRequestException;
import com.acme.ecommerce.rs.product.domain.exception.ProductsByNameNotFoundException;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Put in a global place the exception handling mechanism, this is shared among all the REST Controllers defined
 * in the application. Annotate a handler with the {@link ExceptionHandler} annotation to indicate which error
 * message should return as the response when it is raised.
 *
 * <p>Check some useful reference links
 * <ul>
 * <li><a href="https://www.baeldung.com/global-error-handler-in-a-spring-rest-api">Global Error Handler in A Spring Rest Api</a></li>
 * <li><a href="https://www.youtube.com/watch?v=4YyJUS_7rQE">Spring 6 and Problem Details</a></li>
 * <li><a href="https://mkyong.com/spring-boot/spring-rest-error-handling-example/">Spring REST Error Handling Example</a></li>
 * </ul>
 * </p>
 *
 * @author COQ - Carlos Adolfo Ortiz Quirós
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Defines the message to be returned as the response when the {@link ProductNotFoundException} is raised.
     * Contains the information of the thrown exception to include as part of the response.
     *
     * @param ex Instance to the whole problem.
     * @return A message indicating properly when this exception is raised that the system has not properly managed.
     * @see RuntimeException
     * @see ProductNotFoundException
     * @see ProductsByNameNotFoundException
     * @see ResponseEntity
     * @see CustomErrorResponse
     */
    @ExceptionHandler({ProductNotFoundException.class, ProductsByNameNotFoundException.class})
    public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * Defines the message to be returned as the response when the {@link ProductRequestException} is raised.
     * Contains the information of the thrown exception to include as part of the response.
     *
     * @param ex Instance to the whole problem.
     * @return A message indicating properly when this exception is raised that the system has not properly managed.
     * @see RuntimeException
     * @see ProductRequestException
     * @see ResponseEntity
     * @see CustomErrorResponse
     */
    @ExceptionHandler(ProductRequestException.class)
    public ResponseEntity<CustomErrorResponse> handleProductRequestException(RuntimeException ex) {
        return new ResponseEntity<>(new CustomErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        var instanceURL = ((ServletWebRequest) request).getRequest().getRequestURI(); // This cast is for Servlet use case.

        return this.createResponseEntity(
            ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD)
                .title(TITLE_BAD_REQUEST_ON_PAYLOAD)
                .type(URI.create(instanceURL))
                .instance(URI.create(instanceURL))
                .property(PROPERTY_ERROR_CATEGORY, ERROR_CATEGORY_PARAMETERS)
                .property(PROPERTY_ERRORS,
                    Stream.concat(
                            ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(field -> field.getField() + COLON_SPACE_DELIMITER + field.getDefaultMessage()),
                            ex.getBindingResult()
                                .getGlobalErrors()
                                .stream()
                                .map(field1 -> field1.getObjectName() + COLON_SPACE_DELIMITER + field1.getDefaultMessage())
                        )
                        .sorted()
                        .toList()
                )
                .property(PROPERTY_TIMESTAMP, Instant.now())
                .build(),
            headers, status, request);
    }
}

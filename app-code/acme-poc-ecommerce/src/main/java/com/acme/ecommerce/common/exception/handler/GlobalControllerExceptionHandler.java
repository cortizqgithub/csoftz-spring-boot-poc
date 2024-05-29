/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONTROLLEREXCEPTIONHANDLER.JAVA                       */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 May.28/2024 COQ  Change implementation to use a simplified ProblemDetail output.
                  Use ErrorResponse builder to attach a full detail problem.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.common.exception.handler;

import static com.acme.ecommerce.common.constants.ControllerExceptionHandlerConstants.ERROR_CATEGORY_GENERIC;
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
import java.util.stream.Stream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
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
     * @see ProblemDetail
     */
    @ExceptionHandler({ProductNotFoundException.class, ProductsByNameNotFoundException.class})
    public ResponseEntity<Object> handleProductNotFoundException(RuntimeException ex, WebRequest request) {
        var httpStatus = HttpStatus.NOT_FOUND;
        var problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, ex.getMessage());
        var instanceURL = ((ServletWebRequest) request).getRequest().getRequestURI(); // This cast is for Servlet use case.

        problemDetail.setType(URI.create(instanceURL));
        problemDetail.setInstance(URI.create(instanceURL));
        problemDetail.setProperty(PROPERTY_ERROR_CATEGORY, ERROR_CATEGORY_GENERIC);
        problemDetail.setProperty(PROPERTY_TIMESTAMP, Instant.now());

        // Pending how to extract all headers to comply with HttpHeaders class. May.28/2024
        return this.createResponseEntity(problemDetail, null, httpStatus, request);
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
     * @see ProblemDetail
     */
    @ExceptionHandler(ProductRequestException.class)
    public ResponseEntity<Object> handleProductRequestException(RuntimeException ex, WebRequest request) {
        var httpStatus = HttpStatus.BAD_REQUEST;
        var problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, ex.getMessage());
        var instanceURL = ((ServletWebRequest) request).getRequest().getRequestURI(); // This cast is for Servlet use case.

        problemDetail.setType(URI.create(instanceURL));
        problemDetail.setInstance(URI.create(instanceURL));
        problemDetail.setProperty(PROPERTY_ERROR_CATEGORY, ERROR_CATEGORY_GENERIC);
        problemDetail.setProperty(PROPERTY_TIMESTAMP, Instant.now());

        // Pending how to extract all headers to comply with HttpHeaders class. May.28/2024
        return this.createResponseEntity(problemDetail, null, httpStatus, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        var instanceURL = ((ServletWebRequest) request).getRequest().getRequestURI(); // This cast is for Servlet use case.
        var problemDetail = ProblemDetail.forStatusAndDetail(status, TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD);

        problemDetail.setTitle(TITLE_BAD_REQUEST_ON_PAYLOAD);
        problemDetail.setType(URI.create(instanceURL));
        problemDetail.setInstance(URI.create(instanceURL));
        problemDetail.setProperty(PROPERTY_TIMESTAMP, Instant.now());
        problemDetail.setProperty(PROPERTY_ERROR_CATEGORY, ERROR_CATEGORY_PARAMETERS);
        problemDetail.setProperty(PROPERTY_ERRORS, Stream.concat(
                ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(field -> field.getField() + COLON_SPACE_DELIMITER + field.getDefaultMessage()),
                ex.getBindingResult()
                    .getGlobalErrors()
                    .stream()
                    .map(field1 -> field1.getObjectName() + COLON_SPACE_DELIMITER + field1.getDefaultMessage()))
            .sorted()
            .toList());

        return this.createResponseEntity(problemDetail, headers, status, request);
    }
}

/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERRORRESPONSE.JAVA                                    */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.common.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class CustomErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(LocalDateTime timestamp, int status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorResponse that = (CustomErrorResponse) o;
        return status == that.status && Objects.equals(timestamp, that.timestamp) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, error);
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
            "timestamp=" + timestamp +
            ", status=" + status +
            ", error='" + error + '\'' +
            '}';
    }
}

package com.ust.TaskManager.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {
    public LocalDateTime timestamp;
    public int status;
    public String message;
    public List<String> details;

    public ErrorResponse(int status, String message, List<String> details) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.details = details;
    }
}

package com.exam.haibazo.exception;

import com.exam.haibazo.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException apiException){
        ErrorCode errorCode = apiException.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ApiResponse.builder()
                       .code(errorCode.getCode())
                     .message(errorCode.getMessage())
                     .build());
    }

}

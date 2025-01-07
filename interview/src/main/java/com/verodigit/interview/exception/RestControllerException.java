package com.verodigit.interview.exception;

import com.verodigit.interview.model.APIResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class RestControllerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(APIException.class)
    public ResponseEntity<APIResponse> handleBadRequest(HttpServletRequest req, APIException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage(), false));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleInternalServer(HttpServletRequest req, Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIResponse("Internal Server Error! check logs please.", false));
    }

}

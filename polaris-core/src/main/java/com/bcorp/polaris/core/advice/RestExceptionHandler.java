package com.bcorp.polaris.core.advice;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisAuthenticationException;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.payload.Error;
import com.bcorp.polaris.core.payload.ServerErrorResponse;
import com.bcorp.polaris.core.payload.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request)
    {
        InternalErrorCode errorCode = InternalErrorCode.INVALID_REQUEST_BODY;

        log.error("MethodArgumentNotValidException {}({})", errorCode, errorCode.getCode());
        log.error(ex.getLocalizedMessage());

        log.error("MethodArgumentNotValidException::stack trace:", ex);
        Throwable cause = ex.getCause();
        log.error("MethodArgumentNotValidException::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null)
        {
            log.error("cause::stack trace: ", cause);
        }


        List<Error> errors = new ArrayList<Error>();
        if (!CollectionUtils.isEmpty(ex.getAllErrors()))
        {
            errors = ex.getAllErrors().stream().map(e -> {
                Error error = Error.builder()
                        .field(((FieldError) e).getField())
                        .message(e.getDefaultMessage())
                        .build();
                return error;
            }).collect(Collectors.toList());
        }

        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();

        ServerResponse serverResponse = ServerResponse
                .builder()
                .code(errorCode.getCode())
                .message(errorCode.name())
                .errors(errors)
                .build();

        serverErrorResponse.setError(serverResponse);
        return new ResponseEntity<>(serverErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PolarisServerRuntimeException.class)
    protected ResponseEntity<ServerErrorResponse> handleServerRuntimeException(PolarisServerRuntimeException ex, WebRequest request)
    {
        log.error("PolarisServerRuntimeException {}({})", ex.getErrorCode(), ex.getErrorCode().getCode());
        log.error(ex.getLocalizedMessage());

        log.error("PolarisServerRuntimeException::stack trace:", ex);
        Throwable cause = ex.getCause();
        log.error("PolarisServerRuntimeException::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null)
        {
            log.error("cause::stack trace: ", cause);
        }

        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();
        ServerResponse serverResponse = ServerResponse
                .builder()
                .code(ex.getErrorCode().getCode())
                .message(ex.getMessage())
                .build();

        serverErrorResponse.setError(serverResponse);
        return new ResponseEntity<>(serverErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PolarisAuthenticationException.class)
    protected ResponseEntity<ServerErrorResponse> handleServerRuntimeException(PolarisAuthenticationException ex, WebRequest request)
    {
        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();
        ServerResponse serverResponse = ServerResponse
                .builder()
                .code(401)
                .message("Unauthorized")
                .build();
        serverErrorResponse.setError(serverResponse);
        return new ResponseEntity<>(serverErrorResponse, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ServerErrorResponse> handleRestOfException(Exception ex, WebRequest request)
    {
        log.error("Unhandled Exception", ex);
        log.error(ex.getLocalizedMessage());

        Throwable cause = ex.getCause();
        log.error("Unhandled exception::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null)
        {
            log.error("cause::stack trace: ", cause);
        }

        InternalErrorCode errorCode = InternalErrorCode.INTERNAL_SERVER_ERROR;
        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();
        ServerResponse serverResponse = ServerResponse
                .builder()
                .code(errorCode.getCode())
                .message(ex.getMessage())
                .build();
        serverErrorResponse.setError(serverResponse);
        return new ResponseEntity<>(serverErrorResponse, HttpStatus.BAD_REQUEST);
    }
}

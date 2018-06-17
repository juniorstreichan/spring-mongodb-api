package com.juniorstreichan.mongoapitest.resources.exception;

import com.juniorstreichan.mongoapitest.services.exception.ObjNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjNotFound.class)
    public ResponseEntity<StandardError> objNotFound(ObjNotFound exception, HttpServletRequest request) {

        StandardError erro = new StandardError(
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                "Não encontrado",
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(erro.getStatus()).body(erro);
    }


}

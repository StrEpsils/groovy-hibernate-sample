package ru.kononov.documentBase.restapi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.kononov.documentBase.restapi.util.DocumentBaseException
import ru.kononov.documentBase.restapi.util.RestResponse

/**
 * Created by admin on 18.10.2016.
 */

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler(DocumentBaseException.class)
    public ResponseEntity<RestResponse> exceptionHandler(Exception ex) {
        return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.PRECONDITION_FAILED, ex.message), HttpStatus.BAD_REQUEST)
    }

}

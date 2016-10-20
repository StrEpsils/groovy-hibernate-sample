package ru.kononov.documentBase.restapi.util

import org.springframework.http.HttpStatus

/**
 * Created by admin on 19.10.2016.
 */
class RestResponse {

    HttpStatus status
    String message

    RestResponse(HttpStatus status, String message){
        this.status = status
        this.message = message
    }
    
}

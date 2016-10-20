package ru.kononov.documentBase.restapi.util

/**
 * Created by admin on 19.10.2016.
 */
class DocumentBaseException extends Exception {
    
    private String errorMessage

    DocumentBaseException(String errorMessage) {
        super(errorMessage)
        this.errorMessage = errorMessage
    }
    DocumentBaseException() {
        super()
    }

}

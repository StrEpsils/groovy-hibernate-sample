package ru.kononov.documentBase.restapi.handlers

import org.springframework.http.ResponseEntity

/**
 * Created by admin on 18.10.2016.
 */
interface DocumentHandler {

    ResponseEntity createDocument(String json)
    ResponseEntity updateDocument(String json)
    ResponseEntity deleteDocument(String documentId)
    ResponseEntity findDocument(String name, String documentId)
    ResponseEntity findDocumentsByDocumentType(String documentTypeCode, String documentTypeName)
    ResponseEntity findAll()

}

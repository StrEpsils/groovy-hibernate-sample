package ru.kononov.documentBase.restapi.handlers

import org.springframework.http.ResponseEntity

/**
 * Created by admin on 18.10.2016.
 */
interface AttributeHandler {

    ResponseEntity createAttribute(String json)
    ResponseEntity updateAttribute(String json)
    ResponseEntity deleteAttribute(String attributeId)
    ResponseEntity findAttribute(String attributeName, String attributeId)
    ResponseEntity findAttributesByDocumentType(String idDocumentType)
    ResponseEntity findAll()

}

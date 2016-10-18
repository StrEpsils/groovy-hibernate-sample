package ru.kononov.groovyHibernateSample.restapi.handlers

import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document
import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 18.10.2016.
 */
interface DocumentHandler {

    def createOrUpdateDocument(Document document)
    def deleteDocument(def documentId)
    def findDocument(String name, Long documentId)
    def findDocumentsByDocumentType(String documentTypeCode, String documentTypeName)
    def findAll()

}

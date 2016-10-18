package ru.kononov.groovyHibernateSample.service

import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document
import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentService {

    Long createOrUpdateDocument(Document document) throws Exception
    Long createOrUpdateDocument(DocumentType documentType, String name, List<AttributeValue> attributeValues) throws Exception
    void deleteDocument(Document document) throws Exception
    Document findDocumentByName(String name) throws Exception
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) throws Exception
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) throws Exception
    List<Document> findAll() throws Exception
    Document findDocumentById(Long documentId) throws Exception

}
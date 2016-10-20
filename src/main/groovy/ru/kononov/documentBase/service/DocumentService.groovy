package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.Document

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentService {

    Long saveDocument(Document document) 
    Document updateDocument(Document document) 
    void deleteDocument(Document document) 
    Document findDocumentByName(String name) 
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) 
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) 
    List<Document> findAll() 
    Document findDocumentById(Long documentId) 

}
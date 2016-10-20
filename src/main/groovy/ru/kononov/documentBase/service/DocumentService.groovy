package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.Document

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentService {

    Long saveDocument(Document document) throws Exception
    Document updateDocument(Document document) throws Exception
    void deleteDocument(Document document) throws Exception
    Document findDocumentByName(String name) throws Exception
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) throws Exception
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) throws Exception
    List<Document> findAll() throws Exception
    Document findDocumentById(Long documentId) throws Exception

}
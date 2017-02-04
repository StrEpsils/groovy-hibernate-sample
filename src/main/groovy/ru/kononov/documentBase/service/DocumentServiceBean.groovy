package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.kononov.documentBase.entities.Document
import ru.kononov.documentBase.persistence.DocumentDao
import ru.kononov.documentBase.restapi.util.DocumentBaseException

/**
 * Created by admin on 17.10.2016.
 */

@Service("documentService")
class DocumentServiceBean implements DocumentService{

    @Autowired
    DocumentDao documentDao;

    @Override
    @Transactional
    Long saveDocument(Document document){
        documentDao.save document 
    }

    @Override
    @Transactional
    Document updateDocument(Document document){
        documentDao.update document
    }

    @Override
    @Transactional
    void deleteDocument(Document document) {
        documentDao.delete document
    }

    @Override
    @Transactional
    void deleteDocument(Long documentId) throws DocumentBaseException{
        Document document = documentDao.get documentId
        if (document == null)
            throw new DocumentBaseException("Документ c id = $documentId не найден, удаление невозможно")
        documentDao.delete document
    }

    @Override
    @Transactional(readOnly = true)
    Document findDocumentByName(String name) {
        documentDao.findDocumentByName name
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) {
        documentDao.findDocumentsByDocumentTypeCode documentTypeCode
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) {
        documentDao.findDocumentsByDocumentTypeName documentTypeName
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findAll() {
        documentDao.findAll()
    }

    @Override
    @Transactional(readOnly = true)
    Document findDocumentById(Long documentId){
        documentDao.get documentId
    }
}

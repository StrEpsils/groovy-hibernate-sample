package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.kononov.documentBase.entities.Document
import ru.kononov.documentBase.persistence.DocumentDao

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
        return documentDao.save(document)
    }

    @Override
    @Transactional
    Document updateDocument(Document document){
        return documentDao.update(document)
    }

    @Override
    @Transactional
    void deleteDocument(Document document) {
        documentDao.delete(document)
    }

    @Override
    @Transactional(readOnly = true)
    Document findDocumentByName(String name) {
        return documentDao.findDocumentByName(name)
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) {
        return documentDao.findDocumentsByDocumentTypeCode(documentTypeCode)
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) {
        return documentDao.findDocumentsByDocumentTypeName(documentTypeName)
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findAll() {
        return documentDao.findAll()
    }

    @Override
    @Transactional(readOnly = true)
    Document findDocumentById(Long documentId){
        return documentDao.get(documentId)
    }
}

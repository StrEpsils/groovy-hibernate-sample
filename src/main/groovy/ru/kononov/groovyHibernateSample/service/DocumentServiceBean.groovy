package ru.kononov.groovyHibernateSample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document
import ru.kononov.groovyHibernateSample.entities.DocumentType
import ru.kononov.groovyHibernateSample.persistance.DocumentDao

/**
 * Created by admin on 17.10.2016.
 */

@Service("documentService")
class DocumentServiceBean implements DocumentService{

    @Autowired
    DocumentDao documentDao;

    @Override
    Long createOrUpdateDocument(Document document) throws Exception{
        return documentDao.save()
    }

    @Override
    Long createOrUpdateDocument(DocumentType documentType, String name, List<AttributeValue> attributeValues) throws Exception{
        Document document = new Document()
        document.name(name)
        document.documentType(documentType)
        document.attributeValues(attributeValues)
        return documentDao.save(document)
    }

    @Override
    void deleteDocument(Document document) throws Exception{
        documentDao.delete(document)
    }

    @Override
    Document findDocumentByName(String name) throws Exception{
        return documentDao.findDocumentByName(name)
    }

    @Override
    List<Document> findDocumentsByDocumentTypeCode(String documentTypeCode) throws Exception{
        return documentDao.findDocumentsByDocumentTypeCode(documentTypeCode)
    }

    @Override
    List<Document> findDocumentsByDocumentTypeName(String documentTypeName) throws Exception{
        return documentDao.findDocumentsByDocumentTypeName(documentTypeName)
    }

    @Override
    List<Document> findAll() throws Exception{
        return documentDao.findAll()
    }

    @Override
    Document findDocumentById(Long documentId) throws Exception {
        return documentDao.get(documentId)
    }
}

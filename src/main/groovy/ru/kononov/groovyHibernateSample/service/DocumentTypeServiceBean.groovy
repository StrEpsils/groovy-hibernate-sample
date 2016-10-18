package ru.kononov.groovyHibernateSample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.groovyHibernateSample.entities.DocumentType
import ru.kononov.groovyHibernateSample.persistence.DocumentTypeDao

/**
 * Created by admin on 17.10.2016.
 */
@Service("documentTypeService")
class DocumentTypeServiceBean implements DocumentTypeService{

    @Autowired
    DocumentTypeDao documentTypeDao

    @Override
    Long createOrUpdateDocumentType(DocumentType documentType) {
        return documentTypeDao.save(documentType)
    }

    @Override
    void deleteDocumentType(DocumentType documentType) {
        documentTypeDao.delete(documentType)
    }

    @Override
    DocumentType findDocumentTypesByName(String name) {
        return documentTypeDao.findDocumentTypeByName(name)
    }

    @Override
    DocumentType findDocumentTypesByCode(String code) {
        return documentTypeDao.findDocumentTypeByCode(code)
    }
}

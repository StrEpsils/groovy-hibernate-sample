package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.DocumentType
import ru.kononov.documentBase.persistence.DocumentTypeDao

/**
 * Created by admin on 17.10.2016.
 */
@Service("documentTypeService")
class DocumentTypeServiceBean implements DocumentTypeService{

    @Autowired
    DocumentTypeDao documentTypeDao

    @Override
    Long saveDocumentType(DocumentType documentType){
        return documentTypeDao.save(documentType)
    }

    @Override
    DocumentType updateDocumentType(DocumentType documentType){
        return documentTypeDao.update(documentType)
    }

    @Override
    DocumentType findDocumentTypesByName(String name) {
        return documentTypeDao.findDocumentTypeByName(name)
    }

    @Override
    DocumentType findDocumentTypesByCode(String code) {
        return documentTypeDao.findDocumentTypeByCode(code)
    }

    @Override
    void deleteDocumentType(DocumentType documentType) {

    }
}

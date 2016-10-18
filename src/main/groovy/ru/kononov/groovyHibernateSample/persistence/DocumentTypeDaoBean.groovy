package ru.kononov.groovyHibernateSample.persistence

import org.springframework.stereotype.Repository
import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
@Repository("documentTypeDao")
class DocumentTypeDaoBean extends BaseEntityDaoBean<DocumentType> implements DocumentTypeDao{

    @Override
    DocumentType findDocumentTypeByName(String name) {
        return (DocumentType)currentSession().createQuery(" from DocumentType doc_type where doc_type.name = \'$name\'").singleResult
    }

    @Override
    DocumentType findDocumentTypeByCode(String code) {
        return (DocumentType)currentSession().createQuery(" from DocumentType doc_type where doc_type.code = \'$code\'").singleResult
    }

    @Override
    Class<DocumentType> getClassName() {
        return DocumentType.class
    }
}

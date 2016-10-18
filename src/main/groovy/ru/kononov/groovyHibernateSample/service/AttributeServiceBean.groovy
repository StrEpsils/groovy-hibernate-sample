package ru.kononov.groovyHibernateSample.service

import org.springframework.beans.factory.annotation.Autowired
import ru.kononov.groovyHibernateSample.entities.Attribute
import ru.kononov.groovyHibernateSample.entities.DocumentType
import ru.kononov.groovyHibernateSample.entities.DocumentTypeAttribute
import ru.kononov.groovyHibernateSample.persistance.AttributeDao
import ru.kononov.groovyHibernateSample.persistance.DocumentTypeAttributeDao
import ru.kononov.groovyHibernateSample.persistance.DocumentTypeDao

/**
 * Created by admin on 17.10.2016.
 */
class AttributeServiceBean implements AttributeService{

    @Autowired
    AttributeDao attributeDao
    @Autowired
    DocumentTypeDao documentTypeDao
    @Autowired
    DocumentTypeAttributeDao documentTypeAttributeDao

    @Override
    Long createOrUpdateAttribute(Attribute attribute) {
        return attributeDao.save(attribute)
    }

    @Override
    Long attachAttributeToDocumentType(Attribute attribute, DocumentType documentType) {
        DocumentTypeAttribute documentTypeAttribute = new DocumentTypeAttribute()
        documentTypeAttribute.documentType(documentType)
        documentTypeAttribute.attribute(attribute)
        return documentTypeAttributeDao.save(documentTypeAttribute)
    }

    @Override
    Long attachAttributeToDocumentType(long attributeId, Long documentTypeId) {
        DocumentType documentType = documentTypeDao.get(documentTypeId)
        Attribute attribute = attributeDao.get(attributeId)
        return attachAttributeToDocumentType(attribute, documentType)
    }

    @Override
    void dettachAttributeFromDocumentType(Attribute attribute, DocumentType documentType) {
        dettachAttributeFromDocumentType(attribute.id, documentType.id)
    }

    @Override
    void dettachAttributeFromDocumentType(long attributeId, Long documentTypeId) {
        DocumentTypeAttribute documentTypeAttribute = documentTypeAttributeDao.findDocumentTypeAttributeByDocumentTypeIdAndAttributeId(attributeId, documentTypeId)
        documentTypeAttributeDao.delete(documentTypeAttribute)
    }

    @Override
    List<Attribute> findAllAttributesByDocumentType(DocumentType documentType) {
        return findAllAttributesByDocumentType(documentType.id)
    }

    @Override
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId) {
        return attributeDao.findAllAttributesByDocumentType(documentTypeId)
    }
}

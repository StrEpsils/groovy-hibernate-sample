package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.Attribute
import ru.kononov.documentBase.entities.DocumentType
import ru.kononov.documentBase.entities.DocumentTypeAttribute
import ru.kononov.documentBase.persistence.AttributeDao
import ru.kononov.documentBase.persistence.DocumentTypeAttributeDao
import ru.kononov.documentBase.persistence.DocumentTypeDao
import ru.kononov.documentBase.restapi.util.DocumentBaseException

/**
 * Created by admin on 17.10.2016.
 */

@Service("attributeService")
class AttributeServiceBean implements AttributeService{

    @Autowired
    AttributeDao attributeDao
    @Autowired
    DocumentTypeDao documentTypeDao
    @Autowired
    DocumentTypeAttributeDao documentTypeAttributeDao

    @Override
    Long saveAttribute(Attribute attribute){
        attributeDao.save attribute
    }

    @Override
    Attribute updateAttribute(Attribute attribute){
        attributeDao.update(attribute)
    }

    @Override
    Long attachAttributeToDocumentType(Attribute attribute, DocumentType documentType) {
        DocumentTypeAttribute documentTypeAttribute = new DocumentTypeAttribute()
        documentTypeAttribute.setDocumentType documentType
        documentTypeAttribute.setAttribute attribute
        documentTypeAttributeDao.save documentTypeAttribute
    }

    @Override
    Long attachAttributeToDocumentType(long attributeId, Long documentTypeId) {
        DocumentType documentType = documentTypeDao.get documentTypeId
        Attribute attribute = attributeDao.get attributeId
        attachAttributeToDocumentType(attribute, documentType)
    }

    @Override
    void dettachAttributeFromDocumentType(Attribute attribute, DocumentType documentType) {
        dettachAttributeFromDocumentType(attribute.id, documentType.id)
    }

    @Override
    void dettachAttributeFromDocumentType(long attributeId, Long documentTypeId) {
        DocumentTypeAttribute documentTypeAttribute = documentTypeAttributeDao.findDocumentTypeAttributeByDocumentTypeIdAndAttributeId(attributeId, documentTypeId)
        documentTypeAttributeDao.delete documentTypeAttribute
    }

    @Override
    List<Attribute> findAllAttributesByDocumentType(DocumentType documentType) {
        findAllAttributesByDocumentType documentType.id
    }

    @Override
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId) {
        attributeDao.findAllAttributesByDocumentType documentTypeId
    }

    @Override
    Attribute findAttributeById(Long attributeId){
        attributeDao.get attributeId
    }

    @Override
    void deleteAttribute(Attribute attribute) {
        attributeDao.delete attribute
    }

    @Override
    void deleteAttribute(Long attributeId) throws DocumentBaseException{
        Attribute attribute = attributeDao.get(attributeId)
        assert attribute, new DocumentBaseException("Атрибут с id = $attributeId не найден, удаление невозможно")
        attributeDao.delete attribute
    }
}

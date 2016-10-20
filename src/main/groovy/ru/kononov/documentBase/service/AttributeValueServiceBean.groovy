package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.Attribute
import ru.kononov.documentBase.entities.AttributeValue
import ru.kononov.documentBase.entities.Document
import ru.kononov.documentBase.persistence.AttributeValueDao

/**
 * Created by admin on 17.10.2016.
 */
@Service("attributeValueService")
class AttributeValueServiceBean implements AttributeValueService{

    @Autowired
    AttributeValueDao attributeValueDao;

    @Override
    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId) {
        return attributeValueDao.findAttributeValuesByDocumentId(documentId)
    }

    @Override
    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId) {
        return attributeValueDao.findAttributeValuesByAttributeNameAndDocumentId(attributeName, documentId)
    }

    @Override
    def saveAttributeValue(AttributeValue attributeValue){
        return attributeValueDao.save(attributeValue)
    }

    @Override
    def updateAttributeValue(AttributeValue attributeValue){
        return attributeValueDao.update(attributeValue)
    }

    @Override
    AttributeValue addAttributeValue(String value, Document document, Attribute attribute){
        AttributeValue attributeValue = new AttributeValue()
        attributeValue.setValue(value)
        attributeValue.setAttribute(attribute)
        attributeValue.setDocument(document)
        return attributeValueDao.save(attributeValue)
    }

    @Override
    void deleteAttributeValue(AttributeValue attributeValue) {
        attributeValueDao.delete(attributeValue)
    }

    @Override
    void deleteAttributeValuesByDocument(Document document){
        attributeValueDao.deleteAttributeValuesByDocument(document.id)
    }

    
    @Override
    void deleteAttributeValuesByDocument(Long documentId){
        attributeValueDao.deleteAttributeValuesByDocument(documentId)
    }
}

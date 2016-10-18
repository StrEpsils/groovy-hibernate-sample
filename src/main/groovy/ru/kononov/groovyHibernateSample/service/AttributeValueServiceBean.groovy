package ru.kononov.groovyHibernateSample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kononov.groovyHibernateSample.entities.Attribute
import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document
import ru.kononov.groovyHibernateSample.persistance.AttributeValueDao

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
    Long addAttributeValue(AttributeValue attributeValue) {
        return attributeValueDao.save(attributeValue)
    }

    @Override
    Long addAttributeValue(String value, Document document, Attribute attribute){
        AttributeValue attributeValue = new AttributeValue()
        attributeValue.value(value)
        attributeValue.attribute(attribute)
        attributeValue.document(document)
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

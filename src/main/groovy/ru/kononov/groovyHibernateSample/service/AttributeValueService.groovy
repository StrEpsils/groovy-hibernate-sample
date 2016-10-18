package ru.kononov.groovyHibernateSample.service

import ru.kononov.groovyHibernateSample.entities.Attribute
import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeValueService {

    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId)
    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId)

    Long addAttributeValue(AttributeValue attributeValue)
    Long addAttributeValue(String value, Document document, Attribute attribute)
    void deleteAttributeValue(AttributeValue attributeValue)

    void deleteAttributeValuesByDocument(Document document)
    void deleteAttributeValuesByDocument(Long documentId)
}
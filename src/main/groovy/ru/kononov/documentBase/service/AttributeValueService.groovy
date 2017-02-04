package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.Attribute
import ru.kononov.documentBase.entities.AttributeValue
import ru.kononov.documentBase.entities.Document

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeValueService {

    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId)
    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId)
    Long saveAttributeValue(AttributeValue attributeValue)
    AttributeValue updateAttributeValue(AttributeValue attributeValue)
    Long addAttributeValue(String value, Document document, Attribute attribute)
    void deleteAttributeValue(AttributeValue attributeValue)
    void deleteAttributeValuesByDocument(Document document)
    void deleteAttributeValuesByDocument(Long documentId)
}
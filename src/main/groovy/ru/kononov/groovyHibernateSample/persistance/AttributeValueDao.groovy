package ru.kononov.groovyHibernateSample.persistance

import ru.kononov.groovyHibernateSample.entities.AttributeValue

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeValueDao extends BaseEntityDao<AttributeValue>{

    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId)
    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId)
    void deleteAttributeValuesByDocument(Long documentId)

}
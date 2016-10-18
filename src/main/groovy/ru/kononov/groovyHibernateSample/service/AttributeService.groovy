package ru.kononov.groovyHibernateSample.service

import ru.kononov.groovyHibernateSample.entities.Attribute
import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeService {

    Long createOrUpdateAttribute(Attribute attribute)
    Long attachAttributeToDocumentType(Attribute attribute, DocumentType documentType)
    Long attachAttributeToDocumentType(long attributeId, Long documentTypeId)
    void dettachAttributeFromDocumentType(Attribute attribute, DocumentType documentType)
    void dettachAttributeFromDocumentType(long attributeId, Long documentTypeId)
    List<Attribute> findAllAttributesByDocumentType(DocumentType documentType);
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId);

}
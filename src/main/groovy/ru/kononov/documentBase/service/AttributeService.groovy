package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.Attribute
import ru.kononov.documentBase.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeService {

    Long saveAttribute(Attribute attribute)
    Attribute updateAttribute(Attribute attribute)
    Long attachAttributeToDocumentType(Attribute attribute, DocumentType documentType)
    Long attachAttributeToDocumentType(long attributeId, Long documentTypeId)
    void dettachAttributeFromDocumentType(Attribute attribute, DocumentType documentType)
    void dettachAttributeFromDocumentType(long attributeId, Long documentTypeId)
    List<Attribute> findAllAttributesByDocumentType(DocumentType documentType);
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId);

}
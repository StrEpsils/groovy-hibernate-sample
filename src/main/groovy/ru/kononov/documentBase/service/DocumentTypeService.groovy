package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeService {

    Long saveDocumentType(DocumentType documentType)
    DocumentType updateDocumentType(DocumentType documentType)
    void deleteDocumentType(DocumentType documentType)
    DocumentType findDocumentTypesByName(String name)
    DocumentType findDocumentTypesByCode(String name)

}
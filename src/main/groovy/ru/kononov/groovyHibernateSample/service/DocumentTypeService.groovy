package ru.kononov.groovyHibernateSample.service

import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeService {

    Long createOrUpdateDocumentType(DocumentType documentType)
    void deleteDocumentType(DocumentType documentType)
    DocumentType findDocumentTypesByName(String name)
    DocumentType findDocumentTypesByCode(String name)

}
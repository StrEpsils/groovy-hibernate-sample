package ru.kononov.groovyHibernateSample.persistence

import ru.kononov.groovyHibernateSample.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeDao extends BaseEntityDao<DocumentType>{

    DocumentType findDocumentTypeByName(String name)
    DocumentType findDocumentTypeByCode(String code)

}
package ru.kononov.groovyHibernateSample.persistence

import ru.kononov.groovyHibernateSample.entities.DocumentTypeAttribute

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeAttributeDao extends BaseEntityDao<DocumentTypeAttribute>{

    DocumentTypeAttribute findDocumentTypeAttributeByDocumentTypeIdAndAttributeId(Long attributeId, Long documentTypeId)

}
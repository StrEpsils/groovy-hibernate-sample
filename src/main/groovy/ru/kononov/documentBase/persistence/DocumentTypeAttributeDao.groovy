package ru.kononov.documentBase.persistence

import ru.kononov.documentBase.entities.DocumentTypeAttribute

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeAttributeDao extends BaseEntityDao<DocumentTypeAttribute>{

    DocumentTypeAttribute findDocumentTypeAttributeByDocumentTypeIdAndAttributeId(Long attributeId, Long documentTypeId)

}
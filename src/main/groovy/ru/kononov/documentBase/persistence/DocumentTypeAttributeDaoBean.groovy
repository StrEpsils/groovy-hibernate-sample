package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.DocumentTypeAttribute

/**
 * Created by admin on 17.10.2016.
 */
@Repository("documentTypeAttributeDao")
class DocumentTypeAttributeDaoBean extends BaseEntityDaoBean<DocumentTypeAttribute> implements DocumentTypeAttributeDao{

    @Override
    DocumentTypeAttribute findDocumentTypeAttributeByDocumentTypeIdAndAttributeId(Long documentTypeId, Long attributeId) {
        return (DocumentTypeAttribute)currentSession()
                .createNativeQuery("SELECT * FROM DOCUMENT_TYPE_ATTRIBUTE WHERE DOCUMENT_TYPE_ID = $documentTypeId AND ATTRIBUTE_ID = $attributeId", DocumentTypeAttribute.class).singleResult
    }

    @Override
    Class<DocumentTypeAttribute> getClassName() {
        return DocumentTypeAttribute.class
    }
}

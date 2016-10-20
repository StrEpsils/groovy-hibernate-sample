package ru.kononov.documentBase.persistence

import ru.kononov.documentBase.entities.DocumentType

/**
 * Created by admin on 17.10.2016.
 */
interface DocumentTypeDao extends BaseEntityDao<DocumentType>{

    DocumentType findDocumentTypeByName(String name)
    DocumentType findDocumentTypeByCode(String code)

}
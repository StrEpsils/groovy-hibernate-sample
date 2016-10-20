package ru.kononov.documentBase.persistence

import ru.kononov.documentBase.entities.Attribute

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeDao extends BaseEntityDao<Attribute>{

    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId);

}
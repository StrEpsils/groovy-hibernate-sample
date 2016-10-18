package ru.kononov.groovyHibernateSample.persistence

import ru.kononov.groovyHibernateSample.entities.Attribute

/**
 * Created by admin on 17.10.2016.
 */
interface AttributeDao extends BaseEntityDao<Attribute>{

    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId);

}
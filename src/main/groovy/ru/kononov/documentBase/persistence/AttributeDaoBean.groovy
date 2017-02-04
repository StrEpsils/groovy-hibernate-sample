package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.Attribute

/**
 * Created by admin on 17.10.2016.
 */
@Repository("attributeDao")
class AttributeDaoBean extends BaseEntityDaoBean<Attribute> implements AttributeDao{

    @Override
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId) {
        return (List<Attribute>)currentSession()
                .createQuery("from Attribute attr inner join attr.documentTypeAttribute as doc_type_attribute where doc_type_attribute.id = $documentTypeId").list()
    }

    @Override
    List<Attribute> findAll(){
        super.findAll Attribute.class.name
    }

    @Override
    Class<Attribute> getClassName() {
        return Attribute.class
    }
}

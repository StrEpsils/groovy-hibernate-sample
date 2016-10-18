package ru.kononov.groovyHibernateSample.persistence

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import ru.kononov.groovyHibernateSample.entities.Attribute

/**
 * Created by admin on 17.10.2016.
 */
@Repository("attributeDao")
class AttributeDaoBean extends BaseEntityDaoBean<Attribute> implements AttributeDao{

    @Override
    @Transactional(readOnly = true)
    List<Attribute> findAllAttributesByDocumentType(Long documentTypeId) {
        return (List<Attribute>)currentSession().createQuery("from Attribute attr inner join DocumentTypeAttribute doc_type_attribute where doc_type_attribute.id = \'$documentTypeId\'").list()
    }

    @Override
    @Transactional(readOnly = true)
    List<Attribute> findAll(){
        super.findAll(Attribute.class.name)
    }

    @Override
    Class<Attribute> getClassName() {
        return Attribute.class
    }
}

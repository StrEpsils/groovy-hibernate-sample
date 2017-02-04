package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.AttributeValue

/**
 * Created by admin on 17.10.2016.
 */
@Repository("attributeValueDao")
class AttributeValueDaoBean extends BaseEntityDaoBean<AttributeValue> implements AttributeValueDao{

    @Override
    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId){
        return (List<AttributeValue>)currentSession()
                .createQuery("from AttributeValue val inner join val.document as doc inner join val.attribute as attr where doc.id = $documentId and attr.name = '$attributeName'").list()
    }

    @Override
    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId) {
        return (List<AttributeValue>)currentSession().createQuery("from AttributeValue val inner join val.document doc where doc.id = $documentId").list()
    }

    @Override
    void deleteAttributeValuesByDocument(Long documentId){
        currentSession().createQuery("delete from AttributeValue val left join fetch val.document as doc where doc.id = $documentId").executeUpdate()
    }

    @Override
    Class<AttributeValue> getClassName() {
        return AttributeValue.class
    }
}
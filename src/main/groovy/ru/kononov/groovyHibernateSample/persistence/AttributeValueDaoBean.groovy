package ru.kononov.groovyHibernateSample.persistence

import org.springframework.stereotype.Repository
import ru.kononov.groovyHibernateSample.entities.AttributeValue

/**
 * Created by admin on 17.10.2016.
 */
@Repository("attributeValueDao")
class AttributeValueDaoBean extends BaseEntityDaoBean<AttributeValue> implements AttributeValueDao{

    List<AttributeValue> findAttributeValuesByAttributeNameAndDocumentId(String attributeName, Long documentId){
        return (List<AttributeValue>)currentSession()
                .createQuery("from AttributeValue val left join fetch Document doc left join fetch Attribute attr where doc.id = $documentId and attr.name = \'$attributeName\'").list()
    }

    @Override
    List<AttributeValue> findAttributeValuesByDocumentId(Long documentId) {
        return (List<AttributeValue>)currentSession().createQuery("from AttributeValue val left join fetch Document doc where doc.id = $documentId").list()
    }

    void deleteAttributeValuesByDocument(Long documentId){
        currentSession().createQuery("delete from AttributeValue val left join fetch Document doc where doc.id = $documentId").executeUpdate()
    }

    @Override
    Class<AttributeValue> getClassName() {
        return AttributeValue.class
    }
}

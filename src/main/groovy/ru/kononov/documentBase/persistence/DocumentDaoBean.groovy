package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.Document

/**
 * Created by admin on 15.10.2016.
 */

@Repository("documentDao")
class DocumentDaoBean extends BaseEntityDaoBean<Document> implements DocumentDao{

    @Override
    Document findDocumentByName(String name) {
        return (Document)currentSession().createQuery("from Document doc where doc.name = '$name'").singleResult
    }

    @Override
    List<Document> findDocumentsByDocumentTypeCode(String code) {
        return (List<Document>)currentSession().createQuery("from Document doc inner join doc.documentType as doc_type where doc_type.code = '$code'").list()
    }

    @Override
    List<Document> findDocumentsByDocumentTypeName(String name){
        return (List<Document>)currentSession().createQuery("from Document doc inner join doc.documentType as doc_type where doc_type.name = '$name'").list()
    }

    @Override
    List<Document> findAll(){
        super.findAll(Document.class.name)
    }

    @Override
    Class<Document> getClassName() {
        return Document.class
    }
}
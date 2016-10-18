package ru.kononov.groovyHibernateSample.persistance

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import ru.kononov.groovyHibernateSample.entities.Document

/**
 * Created by admin on 15.10.2016.
 */

@Repository("documentDao")
class DocumentDaoBean extends BaseEntityDaoBean<Document> implements DocumentDao{

    @Override
    @Transactional(readOnly = true)
    Document findDocumentByName(String name) {
        return (Document)currentSession().createQuery("from Document doc where doc.name = \'$name\'").singleResult
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeCode(String code) {
        return (List<Document>)currentSession().createQuery("from Document doc inner join DocumentType doc_type where doc_type.code = \'$code\'").list()
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findDocumentsByDocumentTypeName(String name){
        return (List<Document>)currentSession().createQuery("from Document doc inner join DocumentType doc_type where doc_type.name = \'$name\'").list()
    }

    @Override
    @Transactional(readOnly = true)
    List<Document> findAll(){
        super.findAll(Document.class.name)
    }

    @Override
    Class<Document> getClassName() {
        return Document.class
    }
}
package ru.kononov.groovyHibernateSample.persistence

import ru.kononov.groovyHibernateSample.entities.Document

/**
 * Created by admin on 15.10.2016.
 */
interface DocumentDao extends BaseEntityDao<Document>{

    Document findDocumentByName(String name)
    List<Document> findDocumentsByDocumentTypeCode(String code)
    List<Document> findDocumentsByDocumentTypeName(String name)

}
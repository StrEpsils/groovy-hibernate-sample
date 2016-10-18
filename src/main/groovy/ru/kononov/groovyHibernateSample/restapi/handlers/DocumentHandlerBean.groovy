package ru.kononov.groovyHibernateSample.restapi.handlers

import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kononov.groovyHibernateSample.entities.AttributeValue
import ru.kononov.groovyHibernateSample.entities.Document
import ru.kononov.groovyHibernateSample.entities.DocumentType

import ru.kononov.groovyHibernateSample.service.DocumentService

/**
 * Created by admin on 18.10.2016.
 */

@Service("documentHandler")
class DocumentHandlerBean implements DocumentHandler{

    private static final LOGGER = LogManager.getLogger(DocumentHandlerBean.class)

    @Autowired
    DocumentService documentService

    private String[] documentIgnorableFieldNames = [ "documentType", "attributeValues"]
    private String[] attributeValueIgnorableFieldNames = [ "document" ]
    private String[] attributeIgnorableFieldNames = [ "documentTypes" ]
    private String[] documentTypesIgnorableFieldNames = [ "attributes" ]

    private FilterProvider documentOnlyFilter = new SimpleFilterProvider()
            .addFilter("Document", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(documentIgnorableFieldNames))
    private FilterProvider documentWithDetailFilter = new SimpleFilterProvider()
            .addFilter("Document", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAll())
            .addFilter("DocumentType", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(documentTypesIgnorableFieldNames))
            .addFilter("AttributeValue", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(attributeValueIgnorableFieldNames))
            .addFilter("Attribute", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(attributeIgnorableFieldNames));

    @Override
    def createOrUpdateDocument(Document document) {

    }

    @Override
    def deleteDocument(def documentId) {
        return null
    }

    @Override
    def findDocument(String documentName, Long documentId) {
        if (documentId != null && documentName != null){
            LOGGER.error("Необходимо ввести только один параметр для поиска: documentId или documentName")
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        if (documentId != null && !(documentId instanceof Long)){
            LOGGER.error("Параметр documentId должен иметь целочисленный тип")
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        if (documentName != null && !(documentName instanceof String)){
            LOGGER.error("Параметр documentName должен иметь строковый тип")
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        try {
            return (documentId != null) ?
                    HandlerJsonHelper.responseClosure(documentService.findDocumentById(documentId), "Документ не найден", documentWithDetailFilter) :
                    HandlerJsonHelper.responseClosure(documentService.findDocumentByName(documentName), "Документ не найден", documentWithDetailFilter)
        } catch (Exception e) {
            e.printStackTrace()
            LOGGER.error(e)
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @Override
    def findDocumentsByDocumentType(String documentTypeCode, String documentTypeName) {
        return null
    }

    @Override
    def findAll() {
        try {
            return HandlerJsonHelper.responseClosure(documentService.findAll(), "Документы не найдены", documentOnlyFilter)
        } catch (Exception e) {
            LOGGER.error(e)
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}

package ru.kononov.documentBase.restapi.handlers

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.Document
import ru.kononov.documentBase.restapi.util.DocumentBaseException
import ru.kononov.documentBase.restapi.util.HandlerJsonHelper
import ru.kononov.documentBase.restapi.util.RestResponse
import ru.kononov.documentBase.service.DocumentService

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
    private String[] documentTypesIgnorableFieldNames = [ "attributes", "documents" ]

    private FilterProvider documentOnlyFilter = new SimpleFilterProvider()
            .addFilter("Document", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(documentIgnorableFieldNames))
    private FilterProvider documentWithDetailFilter = new SimpleFilterProvider()
            .addFilter("Document", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAll())
            .addFilter("DocumentType", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(documentTypesIgnorableFieldNames))
            .addFilter("AttributeValue", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(attributeValueIgnorableFieldNames))
            .addFilter("Attribute", (SimpleBeanPropertyFilter)SimpleBeanPropertyFilter.serializeAllExcept(attributeIgnorableFieldNames));

    @Override
    ResponseEntity createDocument(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
            Document document = mapper.setFilterProvider(documentWithDetailFilter).readValue(json, Document.class)
            documentService.saveDocument(document)
            return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.CREATED, "Документ добавлен успешно, присвоен id = $document.id "), HttpStatus.CREATED)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }

    @Override
    ResponseEntity updateDocument(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
            Document document = mapper.setFilterProvider(documentWithDetailFilter).readValue(json, Document.class)
            documentService.updateDocument(document)
            return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.OK, "Документ с id = $document.id успешно обновлён"), HttpStatus.OK)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }

    @Override
    ResponseEntity deleteDocument(String documentId) {
        if (documentId == null)
            throw new DocumentBaseException("Параметр documentId является обязательным")
        Long documentIdLong
        try {
            documentIdLong = Long.parseLong(documentId)
            Document document
            document = documentService.findDocumentById(documentIdLong)
            documentService.deleteDocument(document)
            return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.OK, "Документ с id = $documentId удалён успешно"), HttpStatus.OK)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }

    @Override
    ResponseEntity findDocument(String documentName, String documentId) {
        if (documentId != null && documentName != null)
            throw new DocumentBaseException("Необходимо ввести только один параметр для поиска: documentName или documentId")

        if (documentId == null && documentName == null)
            throw new DocumentBaseException("Необходимо ввести один из параметров для поиска: documentName или documentId")

        try {
            Document document = (documentId != null) ? documentService.findDocumentById(Long.parseLong(documentId)) : documentService.findDocumentByName(documentName)
            return  HandlerJsonHelper.documentBaseResponse(document, "Документ не найден", documentWithDetailFilter)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }

    @Override
    ResponseEntity findDocumentsByDocumentType(String documentTypeCode, String documentTypeName) {
        if (documentTypeCode != null && documentTypeName != null)
            throw new DocumentBaseException("Необходимо ввести только один параметр для поиска: documentTypeCode или documentTypeName")

        if (documentTypeCode != null && !(documentTypeCode instanceof String))
            throw new DocumentBaseException("Параметр documentTypeCode должен иметь строковый тип")

        if (documentTypeName != null && !(documentTypeName instanceof String))
            throw new DocumentBaseException("Параметр documentTypeName должен иметь строковый тип")

        try {
            List<Document> documents = (documentTypeCode != null) ?
                    documentService.findDocumentsByDocumentTypeCode(documentTypeCode) :
                    documentService.findDocumentsByDocumentTypeName(documentTypeName)
            return HandlerJsonHelper.documentBaseResponse(documents, "Документы не найден", documentWithDetailFilter)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }

    @Override
    ResponseEntity findAll() {
        try {
            List<Document> documents = documentService.findAll()
            return HandlerJsonHelper.documentBaseResponse(documents, "Документы не найдены", documentOnlyFilter)
        } catch (Exception e) {
            LOGGER.error(e.localizedMessage)
            return HandlerJsonHelper.badResponse(e)
        }
    }
}

package ru.kononov.groovyHibernateSample.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.kononov.groovyHibernateSample.restapi.handlers.DocumentHandler

/**
 * Created by admin on 18.10.2016.
 */
@RestController
@RequestMapping("/document")
class DocumentApi {

    @Autowired
    DocumentHandler documentHandler

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def findAll(){
        return documentHandler.findAll();
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def findDocumentById(
            @RequestParam(value="documentId", required=false) Long documentId,
            @RequestParam(value="documentName", required=false) String documentName
    ){
        return documentHandler.findDocument(documentName, documentId);
    }

    @RequestMapping(value = "/findByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def findDocumentsByIdDocumentType(
            @RequestParam(value="documentTypeCode", required=false) String documentTypeCode,
            @RequestParam(value="documentTypeName", required=false) String documentTypeName
    ){
        return documentHandler.findDocumentsByDocumentType(documentTypeCode, documentTypeName);
    }

}

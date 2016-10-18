package ru.kononov.groovyHibernateSample.restapi

import org.springframework.beans.factory.annotation.Autowired
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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    def findAll(){
        return documentHandler.findAll();
    }

    @RequestMapping(value = "/findDocumentById", method = RequestMethod.GET)
    def findDocumentById(
            @RequestParam(value="documentId", required=false) Long documentId,
            @RequestParam(value="documentName", required=false) String documentName
    ){
        return documentHandler.findDocument(documentName, documentId);
    }

}

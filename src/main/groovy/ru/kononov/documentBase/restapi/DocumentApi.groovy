package ru.kononov.documentBase.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.kononov.documentBase.restapi.handlers.DocumentHandler

/**
 * Created by admin on 18.10.2016.
 */
@RestController
@RequestMapping("/document")
@PreAuthorize("hasAuthority('user_role')")
class DocumentApi {

    @Autowired
    DocumentHandler documentHandler

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity create(@RequestBody String json){
        return documentHandler.createDocument(json)
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity update(@RequestBody String json){
        return documentHandler.updateDocument(json)
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@RequestParam(value="documentId", required=false) String documentId){
        return documentHandler.deleteDocument(documentId)
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity findAll(){
        return documentHandler.findAll();
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity findDocument(
            @RequestParam(value="documentId", required=false) String documentId,
            @RequestParam(value="documentName", required=false) String documentName
    ){
        return documentHandler.findDocument(documentName, documentId);
    }

    @RequestMapping(value = "/findByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity findDocumentsByIdDocumentType(
            @RequestParam(value="documentTypeCode", required=false) String documentTypeCode,
            @RequestParam(value="documentTypeName", required=false) String documentTypeName
    ){
        return documentHandler.findDocumentsByDocumentType(documentTypeCode, documentTypeName);
    }

}

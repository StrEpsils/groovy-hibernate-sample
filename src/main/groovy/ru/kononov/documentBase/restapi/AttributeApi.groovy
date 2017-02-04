package ru.kononov.documentBase.restapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kononov.documentBase.restapi.handlers.AttributeHandler

/**
 * Created by admin on 17.11.2016.
 */
@RestController
@RequestMapping("/attribute")
class AttributeApi {

    @Autowired
    AttributeHandler attributeHandler

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity create(@RequestBody String json){
        return documentHandler.createDocument(json)
    }

}

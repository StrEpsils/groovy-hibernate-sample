package ru.kononov.documentBase.restapi.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.Attribute
import ru.kononov.documentBase.restapi.util.DocumentBaseException
import ru.kononov.documentBase.restapi.util.HandlerJsonHelper
import ru.kononov.documentBase.restapi.util.RestResponse
import ru.kononov.documentBase.service.AttributeService

/**
 * Created by admin on 18.10.2016.
 *
 */

@Service("attributeHandler")
class AttributeHandlerBean implements AttributeHandler {

    private final static LOGGER = LogManager.getLogger(AttributeHandler.class)

    @Autowired
    AttributeService attributeService

    @Override
    ResponseEntity createAttribute(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
            Attribute attribute = mapper.readValue(json, Attribute.class)
            attributeService.saveAttribute attribute
            new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.CREATED, "Атрибут добавлен успешно, присвоен id = $attribute.id "), HttpStatus.CREATED)
        } catch (Exception e) {
            LOGGER.error e.localizedMessage
            HandlerJsonHelper.badResponse e
        }
    }

    @Override
    ResponseEntity updateAttribute(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
            Attribute attribute = mapper.readValue(json, Attribute.class)
            attributeService.updateAttribute(attribute)
            new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.CREATED, "Атрибут с id = $attribute.id обновлён успешно"), HttpStatus.CREATED)
        } catch (Exception e) {
            LOGGER.error e.localizedMessage
            HandlerJsonHelper.badResponse e
        }
    }

    @Override
    ResponseEntity deleteAttribute(String attributeId) {
        if (!attributeId)
            throw new DocumentBaseException("Параметр attributeId является обязательным")
        Long attributeIdLong
        try {
            attributeIdLong = Long.parseLong attributeId
            Attribute attribute = attributeService.findAttributeById attributeIdLong
            attributeService.deleteAttribute attribute
            new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.OK, "Атрибут с id = $attributeId удалён успешно"), HttpStatus.OK)
        } catch (Exception e) {
            LOGGER.error e.localizedMessage
            HandlerJsonHelper.badResponse e
        }


    }

    @Override
    ResponseEntity findAttribute(String attributeName, String attributeId) {
        return null
    }

    @Override
    ResponseEntity findAttributesByDocumentType(String idDocumentType) {
        return null
    }

    @Override
    ResponseEntity findAll() {
        return null
    }
}

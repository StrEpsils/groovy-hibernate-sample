package ru.kononov.groovyHibernateSample.restapi.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.ser.FilterProvider
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by admin on 18.10.2016.
 */
class HandlerJsonHelper {

    private static final Logger LOGGER = LogManager.getLogger(HandlerJsonHelper.class);

    static protected def responseClosure = { def entity, String messageNotFound, FilterProvider filterProvider ->
        if (entity == null){
            LOGGER.info(messageNotFound)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND)
        } else {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(filterProvider);
            def responseToJson = writer.writeValueAsString(entity)
            return responseToJson
        }
    }

}

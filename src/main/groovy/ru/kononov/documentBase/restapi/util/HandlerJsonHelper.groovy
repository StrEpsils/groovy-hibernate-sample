package ru.kononov.documentBase.restapi.util

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

    public static documentBaseResponse = { def entity, String messageNotFound, FilterProvider filterProvider ->
        if (entity == null) {
            LOGGER.info messageNotFound
            return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.NOT_FOUND, messageNotFound), HttpStatus.NOT_FOUND)
        } else {
            ObjectMapper mapper = new ObjectMapper()
            ObjectWriter writer = mapper.writer filterProvider
            String responseToJson = writer.writeValueAsString entity
            return new ResponseEntity(responseToJson, HttpStatus.OK)
        }
    }

    public static ResponseEntity badResponse (Exception e ) {
        return new ResponseEntity<RestResponse>(new RestResponse(HttpStatus.BAD_REQUEST, "Всё плохо :( $e.localizedMessage"), HttpStatus.BAD_REQUEST)
    }
}

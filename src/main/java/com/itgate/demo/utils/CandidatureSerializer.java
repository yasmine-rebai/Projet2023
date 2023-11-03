package com.itgate.demo.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.itgate.demo.models.Candidature;

import java.io.IOException;
import java.util.List;

public class CandidatureSerializer extends JsonSerializer<List<Candidature>> {
    @Override
    public void serialize(List<Candidature> candidatures, JsonGenerator jgen,
                          SerializerProvider serProv) throws IOException,
            JsonProcessingException {

        jgen.writeStartArray();
        for (Candidature model : candidatures) {
            jgen.writeStartObject();
            jgen.writeObjectField("id", model.getId());
            jgen.writeObjectField("candidat", model.getCandidat());
            jgen.writeObjectField("status", model.getStatus());
            jgen.writeObjectField("score", model.getScore());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();


    }
}

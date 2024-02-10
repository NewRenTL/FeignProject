package com.codigo.feign.service;

import com.codigo.feign.aggregates.requests.PersonaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.fasterxml.jackson.databind.ser.Serializers;

public interface PersonaService {
    BaseResponse crearPersona(PersonaRequest personaRequest);

    BaseResponse getInfoReniec(String number);
}

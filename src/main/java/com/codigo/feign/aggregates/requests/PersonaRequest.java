package com.codigo.feign.aggregates.requests;

import jakarta.persistence.Id;


//This is what we send within the body
public class PersonaRequest {
    private String tipoDoc;
    private String numDoc;

}

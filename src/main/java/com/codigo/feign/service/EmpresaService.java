package com.codigo.feign.service;


import com.codigo.feign.aggregates.requests.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;

public interface EmpresaService {

    BaseResponse crearEmpresa(EmpresaRequest empresaRequest);

    BaseResponse getInfoSunat(String number);
}

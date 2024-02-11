package com.codigo.feign.service.impl;


import com.codigo.feign.aggregates.constants.Constants;
import com.codigo.feign.aggregates.requests.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.feignclient.ReniecClient;
import com.codigo.feign.feignclient.SunatClient;
import com.codigo.feign.repository.EmpresaRepository;
import com.codigo.feign.repository.PersonaRepository;
import com.codigo.feign.service.EmpresaService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    private final SunatClient sunatClient;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, SunatClient sunatClient) {
        this.empresaRepository = empresaRepository;
        this.sunatClient = sunatClient;
    }

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public BaseResponse crearEmpresa(EmpresaRequest empresaRequest) {
        return null;
    }

    @Override
    public BaseResponse getInfoSunat(String number) {
        SunatResponse response = getExecution(number);
        if(response != null)
        {
            return new BaseResponse(Constants.CODE_SUCCESS,Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new BaseResponse(Constants.CODE_ERROR,Constants.MESS_ERROR,Optional.empty());
    }

    private SunatResponse getExecution(String numero)
    {
        String authorization = "Bearer "+tokenApi;
        return sunatClient.getInfo(numero,authorization);
    }
}

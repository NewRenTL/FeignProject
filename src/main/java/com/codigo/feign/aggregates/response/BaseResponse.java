package com.codigo.feign.aggregates.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
public class BaseResponse {
    private int code;
    private String message;
    private Optional data;
}

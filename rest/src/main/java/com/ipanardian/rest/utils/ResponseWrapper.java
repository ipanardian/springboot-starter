package com.ipanardian.rest.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * ResponseWrapper
 */
@Setter
@Getter
public class ResponseWrapper<Any> {
 
    private int code = 200;
    private String message = "success";
    private Any result;
}
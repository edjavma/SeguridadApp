/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.seguridad.utils;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author ejmorales
 */
public class ResponseData<T> {
    
    private Integer code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private T data;

    public ResponseData() {
    }

    public ResponseData(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;        
    }
    
    public ResponseData(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();        
    }

    public ResponseData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
    
    
}

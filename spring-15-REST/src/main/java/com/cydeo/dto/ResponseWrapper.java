package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {


    //custom class response wrapper is created to show what we will see in API jason,
    // name of the custom class can be different
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    // have one constructor without data so when we use delete mapping there will not be data anymore to show
    public ResponseWrapper(String message,Object data){
        this.message = message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }

}

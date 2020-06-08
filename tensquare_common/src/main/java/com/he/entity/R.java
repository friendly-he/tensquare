package com.he.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R {
    private Integer code;
    private Boolean flag;
    private String messsage;
    private Object data;

    private R(){

    }
    public static R OK(){
        R r = new R();
        r.messsage = "成功";
        r.code= StatusCode.OK;
        r.flag = true;
        return r;
    }
    public static R error(){
        R r = new R();
        r.messsage = "失败";
        r.flag = false;
        r.code = StatusCode.ERROR;
        return r;
    }
    public  R code(Integer code){
        this.setCode(code);
        return this;
    }
}


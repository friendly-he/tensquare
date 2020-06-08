package com.he.article.config;

import lombok.Data;

@Data
public class Nullexcention extends RuntimeException {
    private Integer code;
    private String messmag;

    public Nullexcention( Integer code,String messmag){
        this.setCode(code);
        this.setMessmag(messmag);
    }
}

package com.he.article.controller;

import com.he.article.config.Nullexcention;
import com.he.entity.R;
import com.he.entity.StatusCode;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class diyException {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R exception(Exception e){
        System.out.println(e);
        return R.error().setCode(StatusCode.REMOTEERROR);

    }
    @ResponseBody
    @ExceptionHandler(Nullexcention.class)
    public R exceptionnull(Nullexcention e){
        System.out.println(e);
        return R.error().setCode(StatusCode.REMOTEERROR);
    }
}

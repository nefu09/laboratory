package com.example.laboratory.controller;

import com.example.laboratory.exception.MyException;
import com.example.laboratory.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptControllerAdvice {

    @ExceptionHandler(MyException.class)
     public ResultVO exceptionHandle(MyException myException){
        return ResultVO.error(myException.getCode(),myException.getMessage());
    }
}

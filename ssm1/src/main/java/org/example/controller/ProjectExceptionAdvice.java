package org.example.controller;

import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(value = BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        System.out.println("这是Business异常信息");
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(value = SystemException.class)
    public Result doSystemException(SystemException e) {
        System.out.println(e.getMessage());
        System.out.println("这是System异常信息");
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result doException(Exception e) {
        System.out.println("这是Exception异常信息");
        return new Result(Code.SYSTEM_UNKNOWN_ERROR,null,"这是Exception异常信息");
    }
}

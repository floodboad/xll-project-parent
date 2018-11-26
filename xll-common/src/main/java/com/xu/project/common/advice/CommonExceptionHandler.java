package com.xu.project.common.advice;

import com.xu.project.common.exception.XllException;
import com.xu.project.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/19 14:14
 * @Description:  统一处理异常
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(XllException.class)
    public ResponseEntity<ExceptionResult> handlerException(XllException e){
        return ResponseEntity.status(e.getExceptionEnum().getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}

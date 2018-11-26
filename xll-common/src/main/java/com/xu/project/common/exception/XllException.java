package com.xu.project.common.exception;

import com.xu.project.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/19 15:31
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class XllException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}

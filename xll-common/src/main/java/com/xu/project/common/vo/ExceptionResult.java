package com.xu.project.common.vo;

import com.xu.project.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/19 15:48
 * @Description: 异常处理结果实体类 VO
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}

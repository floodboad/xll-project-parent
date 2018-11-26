package com.xu.project.vo;

import lombok.Data;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/25 13:56
 * @Description:
 */
@Data
public class SpuDetail {
    private String description;// 商品描述
    private String specialSpec;// 商品特殊规格的名称及可选值模板
    private String genericSpec;// 商品的全局规格属性
    private String packingList;// 包装清单
    private String afterService;// 售后服务
}

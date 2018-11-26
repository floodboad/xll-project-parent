package com.xu.project.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 02:06
 * @Description:
 */
@Data
@Table(name = "tb_category_brand")
public class CategoryAndBrand {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long categoryId;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long brandId;
}

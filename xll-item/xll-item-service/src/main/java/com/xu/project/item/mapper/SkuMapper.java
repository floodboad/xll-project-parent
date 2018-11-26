package com.xu.project.item.mapper;

import com.xu.project.entity.Sku;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 23:11
 * @Description:
 */
public interface SkuMapper extends Mapper<Sku>, InsertListMapper<Sku> {
}

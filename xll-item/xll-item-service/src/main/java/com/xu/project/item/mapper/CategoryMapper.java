package com.xu.project.item.mapper;

import com.xu.project.entity.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 00:04
 * @Description: 商品分类Mapper
 */
public interface CategoryMapper extends Mapper<Category> , IdListMapper<Category,Long> {
}

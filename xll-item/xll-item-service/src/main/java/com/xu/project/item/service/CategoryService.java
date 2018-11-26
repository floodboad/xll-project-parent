package com.xu.project.item.service;

import com.xu.project.entity.Category;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 00:08
 * @Description:
 */
public interface CategoryService {

    /**
     * @date 2018/11/22 16:25
     * @Description: 查询商品分类信息
     */
    List<Category> queryCategoryListByPid(Long pid);
    /**
     * @date 2018/11/23 15:44
     * @Description: 根据Id的集合查询Category集合信息
     */
    List<Category> queryByIds(List<Long> ids);
}

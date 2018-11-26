package com.xu.project.item.service;

import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Brand;
import com.xu.project.entity.Category;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 15:00
 * @Description: 品牌业务处理
 */
public interface BrandService {

    /**
     * @date 2018/11/22 16:24
     * @Description: 分页查询和排序品牌信息
     */
    PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key);

    /**
     * @date 2018/11/22 16:24
     * @Description: 添加保存品牌信息
     */
    void saveBrand(Brand brand, List<Long> cids);

    List<Category> getBrandById(Long id);

    Brand queryBrandById(Long id);

    List<Brand> queryBrandByCid(Long cid);
}

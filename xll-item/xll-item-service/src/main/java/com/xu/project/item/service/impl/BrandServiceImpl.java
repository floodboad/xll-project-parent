package com.xu.project.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.project.common.enums.ExceptionEnum;
import com.xu.project.common.exception.XllException;
import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Brand;
import com.xu.project.entity.Category;
import com.xu.project.entity.CategoryAndBrand;
import com.xu.project.item.mapper.BrandMapper;
import com.xu.project.item.mapper.CategoryAndBrandMapper;
import com.xu.project.item.mapper.CategoryMapper;
import com.xu.project.item.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 16:20
 * @Description: 品牌业务处理
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryAndBrandMapper categoryAndBrandMapper;

    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * @date 2018/11/22 16:21
     * @Description: 分页查询和排序品牌信息
     */
    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<Brand> list = brandMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new XllException(ExceptionEnum.BRAND_NOT_FIND);
        }
        //解析结果
        PageInfo<Brand> pageInfo = new PageInfo(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    /**
     * @date 2018/11/22 16:22
     * @Description: 添加保存品牌信息
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        for (Long cid : cids) {
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }

    @Override
    public List<Category> getBrandById(Long branId) {
        CategoryAndBrand categoryAndBrand = new CategoryAndBrand();
        categoryAndBrand.setBrandId(branId);
        List<CategoryAndBrand> categoryAndBrandList = categoryAndBrandMapper.select(categoryAndBrand);
        if(CollectionUtils.isEmpty(categoryAndBrandList)){
            throw new XllException(ExceptionEnum.CATEGORY_NOT_FIND);
        }
        List<Category> categoryList = new ArrayList<>();
        for(CategoryAndBrand categoryAndBrand1:categoryAndBrandList){
            Category category = categoryMapper.selectByPrimaryKey(categoryAndBrand1.getCategoryId());
            categoryList.add(category);
            if(category.getIsParent()){
                Category category1 = categoryMapper.selectByPrimaryKey(category.getParentId());
                categoryList.add(category);
            }
        }
        if(CollectionUtils.isEmpty(categoryList)){
            throw new XllException(ExceptionEnum.BRAND_AND_CATEGORY_NOT_FIND);
        }
        return categoryList;
    }

    /**
     * @date 2018/11/23 16:00
     * @Description: 根据Id查询Brand
     */
    public Brand queryBrandById(Long id){
        Brand brand = brandMapper.selectByPrimaryKey(id);
        if(brand == null){
            throw new XllException(ExceptionEnum.BRAND_AND_CATEGORY_NOT_FIND);
        }
        return brand;
    }

    @Override
    public List<Brand> queryBrandByCid(Long cid) {
        List<Brand> brandList = brandMapper.queryByCategoryById(cid);

        if(CollectionUtils.isEmpty(brandList)){
            throw new XllException(ExceptionEnum.BRAND_AND_CATEGORY_NOT_FIND);
        }
        return brandList;
    }
}

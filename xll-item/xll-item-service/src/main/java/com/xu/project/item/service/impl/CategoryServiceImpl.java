package com.xu.project.item.service.impl;

import com.xu.project.common.enums.ExceptionEnum;
import com.xu.project.common.exception.XllException;
import com.xu.project.entity.Category;
import com.xu.project.item.mapper.CategoryMapper;
import com.xu.project.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 16:24
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * @date 2018/11/22 16:25
     * @Description: 查询商品分类信息
     */
    public List<Category> queryCategoryListByPid(Long pid) {
        Category t = new Category();
        t.setParentId(pid);
        //Mapper查询条件：mapper会把对象中的非空属性作为查询条件
        List<Category> list = categoryMapper.select(t);
        if(CollectionUtils.isEmpty(list)) {
            throw new XllException(ExceptionEnum.CATEGORY_NOT_FIND);
        }
        return list;
    }

    /**
     * @date 2018/11/23 15:42
     * @Description: 根据Id的集合查询Category集合信息 （Mapper需要继承IdListMapper<Category,Long>接口）
     */
    public List<Category> queryByIds(List<Long> ids){
        List<Category> categoryList = categoryMapper.selectByIdList(ids);
        if(CollectionUtils.isEmpty(categoryList)) {
            throw new XllException(ExceptionEnum.CATEGORY_NOT_FIND);
        }
        return categoryList;
    }
}

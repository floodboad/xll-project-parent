package com.xu.project.item.service;

import com.xu.project.entity.SpecGroup;
import com.xu.project.entity.Specification;

import java.util.List;

/**
 * @author 徐亮亮
 * @date 2018/11/22 18:59
 * @Description: 规格参数处理 接口
 */
public interface SpecificationService {

    /**
     * @date 2018/11/22 16:34
     * @Description:  查询规格参数信息
     */
    Specification queryById(Long id);

    /**
     * @date 2018/11/22 19:39
     * @Description: 添加规格参数信息
     */
    void insertGroup(SpecGroup specGroup);

    /**
     * @date 2018/11/22 22:02
     * @Description: 更新规格参数信息
     */
    void updateGroup(SpecGroup specGroup);
    /**
     * @date 2018/11/22 19:11
     * @Description: 根据商品分类cid查询规格参数组信息
     */
    List<SpecGroup> querySpecGroupByCid(Long cid);


    List<Specification> querySpecificationByCid(Long cid);
}
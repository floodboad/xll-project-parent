package com.xu.project.item.service.impl;

import com.xu.project.common.enums.ExceptionEnum;
import com.xu.project.common.exception.XllException;
import com.xu.project.entity.SpecGroup;
import com.xu.project.entity.Specification;
import com.xu.project.item.mapper.SpecGroupMapper;
import com.xu.project.item.mapper.SpecificationMapper;
import com.xu.project.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 16:33
 * @Description: 规格参数业务处理
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;

    @Autowired
    private SpecGroupMapper specGroupMapper;
    /**
     * @date 2018/11/22 16:34
     * @Description: 查询规格参数信息
     */
    public Specification queryById(Long id) {
        return this.specificationMapper.selectByPrimaryKey(id);
    }

    /**
     * @date 2018/11/22 19:13
     * @Description: 根据商品分类cid查询规格参数组信息
     */
    @Override
    public List<SpecGroup> querySpecGroupByCid(Long cid) {
        //查询条件
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        //查询语句：select()是以SpecGroup实体类非空字段进行查询
        List<SpecGroup> list = specGroupMapper.select(specGroup);
        if(CollectionUtils.isEmpty(list)){
            throw new XllException(ExceptionEnum.SPEC_GROUP_NOT_FIND);
        }
        return list;
    }

    /**
     * @date 2018/11/22 19:39
     * @Description: 添加规格参数信息
     */
    @Override
    public void insertGroup(SpecGroup specGroup) {
        //添加条件SpecGroup（保存一个实体，null的属性不会保存，会使用数据库默认值）
        int count = specGroupMapper.insertSelective(specGroup);
        if(count <= 0){
            throw new XllException(ExceptionEnum.SPEC_GROUP_INSERT);
        }
    }

    @Override
    public void updateGroup(SpecGroup specGroup) {
        int count = specGroupMapper.updateByPrimaryKey(specGroup);
        if(count <= 0){
            throw new XllException(ExceptionEnum.SPEC_GROUP_UPDATE);
        }
    }

    @Override
    public List<Specification> querySpecificationByCid(Long cid) {
        Specification specification = new Specification();
        specification.setCategoryId(cid);
        List<Specification> specificationList = specificationMapper.select(specification);
        if(CollectionUtils.isEmpty(specificationList)){
            throw new XllException(ExceptionEnum.SPEC_GROUP_NOT_FIND);
        }
        return specificationList;
    }
}

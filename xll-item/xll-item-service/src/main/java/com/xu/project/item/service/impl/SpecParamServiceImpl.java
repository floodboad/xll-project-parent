package com.xu.project.item.service.impl;

import com.xu.project.common.enums.ExceptionEnum;
import com.xu.project.common.exception.XllException;
import com.xu.project.entity.SpecParam;
import com.xu.project.item.mapper.SpecParamMapper;
import com.xu.project.item.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 00:40
 * @Description:
 */
@Service
public class SpecParamServiceImpl implements SpecParamService {

    @Autowired
    private SpecParamMapper specParamMapper;
    @Override
    public List<SpecParam> queryParamList(Long gid,Long cid,Boolean searching) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setSearching(searching);
        List<SpecParam> specParamList = specParamMapper.select(specParam);
        if(CollectionUtils.isEmpty(specParamList)){
            throw new XllException(ExceptionEnum.SPEC_PARAMS_NOT_FIND);
        }
        return specParamList;
    }

    @Override
    public void insertSpecParam(SpecParam specParam) {
        int count = specParamMapper.insertSelective(specParam);
        if(count<=0){
            throw new XllException(ExceptionEnum.SPEC_PARAMS_NOT_INSERT);
        }
    }

    @Override
    public void updateSpecParamById(SpecParam specParam) {
        int count = specParamMapper.updateByPrimaryKey(specParam);
        if(count<=0){
            throw new XllException(ExceptionEnum.SPEC_PARAMS_NOT_INSERT);
        }
    }

    @Override
    public void deleteSpecParamById(Long id) {
        SpecParam specParam = new SpecParam();
        specParam.setId(id);
        int count = specParamMapper.deleteByPrimaryKey(specParam);
        if(count<=0){
            throw new XllException(ExceptionEnum.SPEC_PARAMS_NOT_DELETE);
        }
    }
}


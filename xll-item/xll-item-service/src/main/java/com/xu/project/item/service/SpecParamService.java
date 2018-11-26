package com.xu.project.item.service;

import com.xu.project.entity.SpecParam;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 00:39
 * @Description:
 */
public interface SpecParamService {

    List<SpecParam> queryParamList(Long gid,Long cid,Boolean searching);

    void insertSpecParam(SpecParam specParam);

    void updateSpecParamById(SpecParam specParam);

    void deleteSpecParamById(Long id);
}

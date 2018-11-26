package com.xu.project.item.service;

import com.xu.project.bo.SpuBo;
import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Spu;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 22:20
 * @Description:
 */
public interface SpuService {
    PageResult<Spu> querySpuByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key, Boolean saleable);

    SpuBo selectSpuById(Long id);

    Spu getSpuById(Long id);
}

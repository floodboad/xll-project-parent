package com.xu.project.item.service;

import com.xu.project.entity.Sku;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/25 14:56
 * @Description:
 */
public interface SkuService {
    List<Sku> querySkuListBySpuId(Long id);
}

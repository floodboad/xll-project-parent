package com.xu.project.item.service.impl;

import com.xu.project.entity.Sku;
import com.xu.project.entity.Stock;
import com.xu.project.item.mapper.SkuMapper;
import com.xu.project.item.mapper.StockMapper;
import com.xu.project.item.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/25 14:57
 * @Description:
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private StockMapper stockMapper;
    @Override
    public List<Sku> querySkuListBySpuId(Long id) {
        Sku sku = new Sku();
        sku.setSpuId(id);
        List<Sku> skuList = skuMapper.select(sku);
        List<Long> ids = skuList.stream().map(Sku::getId).collect(Collectors.toList());
        List<Stock> stockList = stockMapper.selectByIdList(ids);
        Map<Long, Integer> stockMap = stockList.stream().collect(Collectors.toMap(Stock::getSkuId, Stock::getStock));
        skuList.forEach(s -> sku.setStock(stockMap.get(s.getId())));
        return skuList;
    }
}

package com.xu.project.item.service.impl;

import com.xu.project.common.enums.ExceptionEnum;
import com.xu.project.common.exception.XllException;
import com.xu.project.entity.Sku;
import com.xu.project.entity.Spu;
import com.xu.project.entity.Stock;
import com.xu.project.item.mapper.SkuMapper;
import com.xu.project.item.mapper.SpuDetailMapper;
import com.xu.project.item.mapper.SpuMapper;
import com.xu.project.item.mapper.StockMapper;
import com.xu.project.item.service.GoodsService;
import com.xu.project.vo.SpuDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 23:11
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private StockMapper stockMapper;
    @Transactional
    @Override
    public void insertGoods(Spu spu) {
        //添加Spu
        spu.setSaleable(true);
        spu.setCreateTime(new Date());
        spu.setLastUpdateTime(spu.getCreateTime());
        spu.setValid(false);
        int count = spuMapper.insert(spu);
        if(count != 1){
            throw new XllException(ExceptionEnum.GOODS_SAVE_ERROR);
        }
        //添加 spuDetail
        SpuDetail spuDetailVo = spu.getSpuDetail();
        com.xu.project.entity.SpuDetail spuDetail = new com.xu.project.entity.SpuDetail();
        spuDetail.setSpuId(spu.getId());
        spuDetail.setAfterService(spuDetailVo.getAfterService());
        spuDetail.setDescription(spuDetailVo.getDescription());
        spuDetail.setPackingList(spuDetailVo.getPackingList());
        spuDetail.setSpecifications(spuDetailVo.getGenericSpec());
        spuDetail.setSpecTemplate(spuDetailVo.getSpecialSpec());
        int spuDetailCount = spuDetailMapper.insert(spuDetail);
        if(spuDetailCount != 1){
            throw new XllException(ExceptionEnum.GOODS_SAVE_ERROR);
        }
        //解析处理sku字段
        List<Sku> skuList = spu.getSkus();
        List<Stock> stockList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(skuList)){
            for (Sku sku : skuList) {
                sku.setCreateTime(new Date());
                sku.setLastUpdateTime(sku.getCreateTime());
                sku.setSpuId(spu.getId());
                //批量添加sku
                int skuCount = skuMapper.insert(sku);
                if(skuCount != 1){
                    throw new XllException(ExceptionEnum.GOODS_SAVE_ERROR);
                }
                //解析处理stock字段
                Stock stock = new Stock();
                stock.setSkuId(sku.getId());
                stock.setStock(sku.getStock());
                stockList.add(stock);
            }
            //批量添加库存
            int stockCount = stockMapper.insertList(stockList);
            if(stockCount != 1){
                throw new XllException(ExceptionEnum.GOODS_SAVE_ERROR);
            }
        }
    }
}

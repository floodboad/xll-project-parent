package com.xu.project.bo;

import com.xu.project.entity.Sku;
import com.xu.project.entity.Spu;
import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

@Data
public class SpuBo extends Spu {

    @Transient
    String category;// 商品分类名称
    @Transient
    String brand;// 品牌名称
//    @Transient
//    SpuDetail spuDetail;// 商品详情
    @Transient
    List<Sku> skus;// sku列表
}
package com.xu.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xu.project.vo.SpuDetail;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long brandId;
    private Long cid1;// 1级类目
    private Long cid2;// 2级类目
    private Long cid3;// 3级类目
    private String title;// 标题
    private String subTitle;// 子标题
    private Boolean saleable;// 是否上架
    private Boolean valid;// 是否有效，逻辑删除用
    private Date createTime;// 创建时间
    @JsonIgnore/*返回值json参数忽略该字段*/
    private Date lastUpdateTime;// 最后修改时间

    @Transient  /*去除该字段不去映射数据库字段（该字段为中间字段）*/
    private String category;// 商品分类名称
    @Transient
    private String brand;// 品牌名称

    @Transient
    private List<Sku> skus;
    @Transient
    private SpuDetail spuDetail;
}
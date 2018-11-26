package com.xu.project.item.mapper;

import com.xu.project.entity.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 14:04
 * @Description: 商品品牌管理
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * @date 2018/11/23 16:56
     * @Description: 关联表查询语句
     */
    @Select("SELECT b.* FROM tb_category_brand cd INNER JOIN tb_brand b ON b.id = cd.brand_id WHERE cd.category_id=#{cid}")
    List<Brand> queryByCategoryById(@Param("cid")Long cid);
}


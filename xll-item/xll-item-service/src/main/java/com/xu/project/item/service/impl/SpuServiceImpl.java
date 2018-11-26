package com.xu.project.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.project.bo.SpuBo;
import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Brand;
import com.xu.project.entity.Category;
import com.xu.project.entity.Spu;
import com.xu.project.entity.SpuDetail;
import com.xu.project.item.mapper.SkuMapper;
import com.xu.project.item.mapper.SpuDetailMapper;
import com.xu.project.item.mapper.SpuMapper;
import com.xu.project.item.service.BrandService;
import com.xu.project.item.service.CategoryService;
import com.xu.project.item.service.SpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 22:20
 * @Description:
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public PageResult<Spu> querySpuByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key, Boolean saleable) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%").orEqualTo("brand", key);
        }
        //上下架过滤
        if(saleable != null){
            criteria.andEqualTo("saleable",saleable);
        }
        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }else {
            example.setOrderByClause("last_update_time DESC");
        }
        // 查询
        List<Spu> list = spuMapper.selectByExample(example);
//        if(CollectionUtils.isEmpty(list)){
//            throw new XllException(ExceptionEnum.BRAND_NOT_FIND);
//        }
        //解析分类和品牌名称
        LoadCategoryAndBrand(list);
        //解析结果
        PageInfo<Spu> pageInfo = new PageInfo(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }
    private void LoadCategoryAndBrand(List<Spu> list) {
        for (Spu spu: list){
            //解析分类名称
            List<String> names = categoryService.queryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()))
                    .stream().map(Category::getName).collect(Collectors.toList());
            spu.setCategory(StringUtils.join(names,"/"));
            //解析品牌名称
            Brand brand = brandService.queryBrandById(spu.getBrandId());
            spu.setBrand(brand.getName());
        }
    }

    @Override
    public SpuBo selectSpuById(Long id) {
//        Spu spu = new Spu();
//        spu.setId(id);
//        spu = spuMapper.selectByPrimaryKey(spu);
//        SpuDetail spuDetail = new SpuDetail();
//        spuDetail.setSpuId(id);
//        SpuDetail spuDetail1 = spuDetailMapper.selectByPrimaryKey(spuDetail);
//        SpuBo spuBo = new SpuBo();
//        spuBo.setSpuDetail(spuDetail);
//        Sku sku = new Sku();
//        sku.setSpuId(id);
//        List<Sku> skuList = skuMapper.select(sku);
//        spuBo.setSkus(skuList);
//        return spuBo;
        return null;
    }

    @Override
    public Spu getSpuById(Long id) {
        SpuDetail spuDetail = spuDetailMapper.selectByPrimaryKey(id);
        Spu spu = new Spu();
        com.xu.project.vo.SpuDetail spuDetailVo = new com.xu.project.vo.SpuDetail();
        spuDetailVo.setAfterService(spuDetail.getAfterService());
        spuDetailVo.setDescription(spuDetail.getDescription());
        spuDetailVo.setGenericSpec(spuDetail.getSpecifications());
        spuDetailVo.setPackingList(spuDetail.getPackingList());
        spuDetailVo.setSpecialSpec(spuDetail.getSpecTemplate());
        spu = spuMapper.selectByPrimaryKey(id);
        spu.setSpuDetail(spuDetailVo);
        return spu;
    }
}

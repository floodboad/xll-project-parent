package com.xu.project.item.controller;

import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Brand;
import com.xu.project.entity.Category;
import com.xu.project.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 14:04
 * @Description:品牌管理
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = this.brandService.queryBrandByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);/*返回一个成功或失败消息值*/
        }
        return ResponseEntity.ok(result);
    }

    /**
     * @date 2018/11/22 21:45
     * @Description: 新增品牌 Restful风格 （Post为添加信息）
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        this.brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build(); /*无返回值返回*/
    }
    @GetMapping("brandId")
    public ResponseEntity<List<Category>> getBrandById(@RequestParam("id")Long id){
        List<Category> categoryList = brandService.getBrandById(id);
        return ResponseEntity.ok(categoryList);
    }

    /**
     * @date 2018/11/23 16:46
     * @Description: 根据cid查询Brand品牌
     */
    @GetMapping("/cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandByCid(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(brandService.queryBrandByCid(cid));
    }
}

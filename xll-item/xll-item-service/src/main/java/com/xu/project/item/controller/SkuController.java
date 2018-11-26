package com.xu.project.item.controller;

import com.xu.project.entity.Sku;
import com.xu.project.item.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/25 14:56
 * @Description:
 */
@RestController
@RequestMapping("sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping("list")
    public ResponseEntity<List<Sku>> querySkuListBySpuId(@RequestParam("id")Long id){
        return ResponseEntity.ok(skuService.querySkuListBySpuId(id));
    }
}

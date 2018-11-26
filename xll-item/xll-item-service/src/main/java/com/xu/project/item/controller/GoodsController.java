package com.xu.project.item.controller;

import com.xu.project.entity.Spu;
import com.xu.project.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 23:10
 * @Description:
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @PostMapping
    public ResponseEntity<Void> insertGoods(@RequestBody Spu spu){
        goodsService.insertGoods(spu);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

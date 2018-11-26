package com.xu.project.item.controller;

import com.xu.project.entity.SpecParam;
import com.xu.project.item.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/23 00:40
 * @Description: 参数属性信息
 */
@RestController
@RequestMapping("spec")
public class SpecParamController {
    @Autowired
    private SpecParamService specParamService;
    /**
     * @date 2018/11/23 1:04
     * @Description: 查询规格参数属性列表
     * @Param searching 是否搜索
     * @Param gic 组id
     * @Param cid 分类Id
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> getSpecParamsByGid(
            @RequestParam(value = "searching", required = false) Boolean searching,
            @RequestParam(value = "gid", required = false)Long gid,
            @RequestParam(value = "cid",required = false)Long cid){
        List<SpecParam> specParam = specParamService.queryParamList(gid,cid,searching);
        return ResponseEntity.ok(specParam);
    }
    /**
     * @date 2018/11/23 1:04
     * @Description: 添加规格参数属性
     */
    @PostMapping("param")
    public ResponseEntity<Void> insertSpecParam(@RequestBody SpecParam specParam){
        specParamService.insertSpecParam(specParam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /**
     * @date 2018/11/23 1:11
     * @Description: 更新规格参数属性
     */
    @PutMapping("param")
    public ResponseEntity<Void> upadteSpecParamById(@RequestBody SpecParam specParam){
        specParamService.updateSpecParamById(specParam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteSpecParamById(@PathVariable("id") Long id){
        specParamService.deleteSpecParamById(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

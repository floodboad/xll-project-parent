package com.xu.project.item.controller;

import com.xu.project.entity.SpecGroup;
import com.xu.project.entity.Specification;
import com.xu.project.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 徐亮亮
 * @date 2018/11/22 16:36
 * @Description: 规格参数处理信息
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * @date 2018/11/22 16:36
     * @Description: 查询规格产品管理信息
     */
//    @GetMapping("/groups/{id}")
    public ResponseEntity<String> querySpecificationByCategoryId(@PathVariable("id") Long id){
        Specification spec = this.specificationService.queryById(id);
        if (spec == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(spec.getSpecifications());
    }

    /**
     * @date 2018/11/22 19:35
     * @Description: 添加规格参数组信息
     *          前端是以json的格式传输，所以后台接收必须也以json方式接收（@RequestBody）
     */
    @PostMapping("/groups")
    public ResponseEntity<Void> insertGroup(@RequestBody SpecGroup specGroup){
        specificationService.insertGroup(specGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/groups")
    public ResponseEntity<Void> updateGroup(@RequestBody SpecGroup specGroup){
        specificationService.updateGroup(specGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * @date 2018/11/22 19:19
     * @Description: 查询规格参数组信息
     */
    @GetMapping("/groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecGroupByCid(@PathVariable("cid")Long cid){
        List<SpecGroup> groupList = specificationService.querySpecGroupByCid(cid);
        return ResponseEntity.ok(groupList);
    }

    /**
     * @date 2018/11/22 19:19
     * @Description: 查询规格参数组信息
     */
    @GetMapping("{cid}")
    public ResponseEntity<List<Specification>> querySpecificationByCid(@PathVariable("cid")Long cid){
        List<Specification> groupList = specificationService.querySpecificationByCid(cid);
        return ResponseEntity.ok(groupList);
    }
}
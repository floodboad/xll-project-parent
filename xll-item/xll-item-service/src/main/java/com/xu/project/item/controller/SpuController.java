package com.xu.project.item.controller;

import com.xu.project.common.vo.PageResult;
import com.xu.project.entity.Spu;
import com.xu.project.item.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/22 22:19
 * @Description:
 */
@RestController
@RequestMapping("goods")
public class SpuController {

    @Autowired
    private SpuService spuService;
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<Spu>> queryBuSpuList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false",required = false) Boolean desc,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable",required = false)Boolean saleable){

        PageResult<Spu> result = this.spuService.querySpuByPageAndSort(page,rows,sortBy,desc, key,saleable);
//        if (result == null || result.getItems().size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/spu/{id}")
//    public ResponseEntity<SpuBo> selectSpuById(@RequestParam("id")Long id){
//        SpuBo spuBo = spuService.selectSpuById(id);
//        return ResponseEntity.ok(spuBo);
//    }

    @GetMapping("/spu/detail")
    public ResponseEntity<Spu> getSpuBuId(@RequestParam("id")Long id){
        return ResponseEntity.ok(spuService.getSpuById(id));
    }
}

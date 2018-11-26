package com.xu.project.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/19 15:33
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    BRAND_NOT_FIND(404,"产品不存在"),
    BRAND_AND_CATEGORY_NOT_FIND(400,"品牌未找到相对应的分类"),
    CATEGORY_NOT_FIND(400,"商品分类没查到"),


    SPEC_GROUP_NOT_FIND(400,"规格参数组没查到"),
    SPEC_GROUP_INSERT(400,"规格参数组信息添加失败"),
    SPEC_GROUP_UPDATE(400,"规格参数组更新失败"),
    SPEC_PARAMS_NOT_FIND(400,"规格参数属性没有找到"),
    SPEC_PARAMS_NOT_INSERT(400,"规格参数属性添加失败"),
    SPEC_PARAMS_NOT_UPDATE(400,"规格参数属性更新失败"),
    SPEC_PARAMS_NOT_DELETE(400,"规格参数属性删除失败"),

    GOODS_SAVE_ERROR(500,"商品保存失败")

    ;
    private int code;
    private String msg;
}

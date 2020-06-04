package com.mobile.mall.goods.controller;

import com.mobile.mall.goods.db.domain.MallBrand;
import com.mobile.mall.goods.dto.MallDto;
import com.mobile.mall.goods.services.GoodsService;
import com.mobile.mall.utils.com.mobile.mall.utils.web.ResponseUtil;
import com.mobile.mall.utils.dto.request.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "测试接口", tags = "GoodsController", description = "测试货品接口相关")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation("测试")
    public BaseResponse hello()
    {
        return ResponseUtil.ok("hello");
    }

    @RequestMapping(value = "/allBrand", method = RequestMethod.GET)
    @ApiOperation("获取所有货品品牌")
    public BaseResponse getAllBrand()
    {
        return ResponseUtil.okList(goodsService.allBrand());
    }
}

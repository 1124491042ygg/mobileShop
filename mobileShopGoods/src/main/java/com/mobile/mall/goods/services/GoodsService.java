package com.mobile.mall.goods.services;

import com.mobile.mall.goods.db.dao.MallBrandMapper;
import com.mobile.mall.goods.db.dao.MallGoodsMapper;
import com.mobile.mall.goods.db.domain.MallBrand;
import com.mobile.mall.goods.db.domain.MallBrandExample;
import com.mobile.mall.goods.db.domain.MallGoods;
import com.mobile.mall.goods.db.domain.MallGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private MallBrandMapper mallBrandMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    /**
     * 获取所有品牌信息
     * @return
     */
    public List<MallBrand> allBrand(){
        MallBrandExample example = new MallBrandExample();
        example.orderBy("add_time");
        MallBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedNotEqualTo(true);
        return mallBrandMapper.selectByExample(example);
    }

    /**
     * 获取所有品牌信息
     * @return
     */
    public List<MallGoods> allGoodsByBrand(Integer brandId){
        MallGoodsExample example = new MallGoodsExample();
        example.orderBy("sort_order");
        MallGoodsExample.Criteria criteria = example.createCriteria();
        if(brandId > 0) {
            criteria.andBrandIdEqualTo(brandId);
        }
        criteria.andDeletedEqualTo(false);
        return mallGoodsMapper.selectByExample(example);
    }
}

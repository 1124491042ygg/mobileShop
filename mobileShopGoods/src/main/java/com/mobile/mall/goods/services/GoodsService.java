package com.mobile.mall.goods.services;

import com.mobile.mall.goods.db.dao.MallBrandMapper;
import com.mobile.mall.goods.db.domain.MallBrand;
import com.mobile.mall.goods.db.domain.MallBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private MallBrandMapper mallBrandMapper;

    public List<MallBrand> allBrand(){
        MallBrandExample example = new MallBrandExample();
        example.orderBy("add_time");
        MallBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedNotEqualTo(false);
        return mallBrandMapper.selectByExample(example);
    }
}

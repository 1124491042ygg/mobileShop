package com.mobile.mall.home.services;

import com.mobile.mall.home.db.domain.MallCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    private MallCollect mallCollect;
}

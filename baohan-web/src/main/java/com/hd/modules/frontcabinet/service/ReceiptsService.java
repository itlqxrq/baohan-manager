package com.hd.modules.frontcabinet.service;

import com.hd.modules.frontcabinet.entity.Customer;
import com.hd.modules.frontcabinet.entity.ManIfest;

import java.util.List;

/*
* 收货录用
* */
public interface ReceiptsService {

    //根据客户的唛头查出客户的名称
    Customer queryCustomerByName(String cusCode);

    //保存收货录用订单
    void saveManIfest(ManIfest manIfest);

    /**根据pageIndex获取货物信息*/
    List<ManIfest> getGoodsPage(Integer pageIndex,Integer limit);
}

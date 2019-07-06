package com.hd.modules.frontcabinet.dao;

import com.hd.modules.frontcabinet.entity.Customer;
import com.hd.modules.frontcabinet.entity.ManIfest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component

public interface ReceiptsDao {
    //根据客户的唛头查出客户的名称
    Customer queryCustomerByName(String cuscode);

    //保存收货录用订单
    void saveManIfest(ManIfest manIfest);

    /**根据pageIndex获取货物列表信息*/
    List<ManIfest> getGoodsPage(Integer start,Integer limit);
}

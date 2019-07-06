package com.hd.modules.frontcabinet.controller;

import com.hd.common.utils.R;
import com.hd.modules.frontcabinet.entity.Customer;
import com.hd.modules.frontcabinet.entity.ManIfest;
import com.hd.modules.frontcabinet.service.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* 收货录用
*/
@RestController
@RequestMapping("frontcabinet/receipts")
public class ReceiptsController {
    @Autowired
    private ReceiptsService receiptsService;
    //根据客户的唛头查询出客户的名称和业务员的名称
    @RequestMapping("/getName")
    public Customer getName(String cuscode){
        System.out.println(cuscode);
        Customer customer = receiptsService.queryCustomerByName(cuscode);
        System.out.println(customer);
        return customer;
    }

    //保存收货录用订单
    @RequestMapping("/addManifest")
    public R addManifest(@RequestBody ManIfest manIfest){
        System.out.println(manIfest);
        receiptsService.saveManIfest(manIfest);
        return R.ok().put("收货录用成功", manIfest);
    }

}

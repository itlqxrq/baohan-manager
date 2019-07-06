package com.hd.modules.sys.controller;

import com.hd.modules.sys.entity.SysCurrencyHistoryEntity;
import com.hd.modules.sys.service.SysCurrencyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XA
 * @date  下午 15:03
 * @description 币别资料控制类
 * @params
 * @return
 */
@RestController
@RequestMapping("/sys/currencyHistory")
public class SysCurrencyHistoryController {
    @Autowired
    private SysCurrencyHistoryService sysCurrencyHistoryService;

    @RequestMapping("/currencySecForHistyor")
    public List<SysCurrencyHistoryEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate){
        return sysCurrencyHistoryService.currencySecForHistyor(name,nameEn,startDate,endDate);
    }

    @RequestMapping("/getPageData")
    public List<SysCurrencyHistoryEntity> getPageData(Integer pageIndex,Integer limit){
        return sysCurrencyHistoryService.getPageData(pageIndex,limit);
    }

}

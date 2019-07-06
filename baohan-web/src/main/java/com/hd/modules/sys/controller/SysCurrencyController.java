package com.hd.modules.sys.controller;

import com.hd.common.utils.R;
import com.hd.modules.sys.entity.SysCurrencyEntity;
import com.hd.modules.sys.service.SysCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/sys/currency")
public class SysCurrencyController {
    @Autowired
    private SysCurrencyService sysCurrencyService;
    @RequestMapping("/currencyAdd")
    public R currencyAdd(@RequestBody SysCurrencyEntity sysCurrencyEntity){
        sysCurrencyService.currencyAdd(sysCurrencyEntity);
        return R.ok("币别资料添加成功！");
    }

    @RequestMapping("/currencyDelById")
    public R currencyDelById(Integer currencyId){
        sysCurrencyService.currencyDelById(currencyId);
        return R.ok("币别资料删除成功！");
    }

    @RequestMapping("/currencyEdit")
    public R currencyEdit(@RequestBody SysCurrencyEntity sysCurrencyEntity){
        sysCurrencyService.currencyEdit(sysCurrencyEntity);
        return R.ok("币别资料修改成功！");
    }

    @RequestMapping("/currencySec")
    public List<SysCurrencyEntity> currencySec(SysCurrencyEntity sysCurrencyEntity){
        return sysCurrencyService.currencySec(sysCurrencyEntity);
    }

    @RequestMapping("/currencySecForHistyor")
    public List<SysCurrencyEntity> currencySecForHistyor(String name,String nameEn,String startDate,String endDate){
        return sysCurrencyService.currencySecForHistyor(name,nameEn,startDate,endDate);
    }

    @RequestMapping("/getPageData")
    public List<SysCurrencyEntity> getPageData(Integer pageIndex,Integer limit){
        return sysCurrencyService.getPageData(pageIndex,limit);
    }
}

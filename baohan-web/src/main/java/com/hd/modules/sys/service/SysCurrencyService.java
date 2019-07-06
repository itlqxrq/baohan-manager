package com.hd.modules.sys.service;

import com.hd.modules.sys.entity.SysCurrencyEntity;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/4 0004 下午 14:17
 * @description 币别资料业务接口
 * @params 
 * @return 
 */
public interface SysCurrencyService {
    void currencyAdd(SysCurrencyEntity sysCurrencyEntity);
    void currencyDelById(Integer currencyId);
    void currencyEdit(SysCurrencyEntity sysCurrencyEntity);
    List<SysCurrencyEntity> currencySec(SysCurrencyEntity sysCurrencyEntity);
    List<SysCurrencyEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate);
    List<SysCurrencyEntity> getPageData(Integer start, Integer limit);
}

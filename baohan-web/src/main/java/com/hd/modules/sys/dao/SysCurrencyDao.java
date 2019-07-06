package com.hd.modules.sys.dao;

import com.hd.modules.sys.entity.SysCurrencyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/4 0004 下午 14:14
 * @description 币别资料Dao
 * @params
 * @return
 */
@Mapper
@Component
public interface SysCurrencyDao {
    void currencyAdd(SysCurrencyEntity sysCurrencyEntity);
    void currencyDelById(Integer currencyId);
    void currencyEdit(SysCurrencyEntity sysCurrencyEntity);
    List<SysCurrencyEntity> currencySec(SysCurrencyEntity sysCurrencyEntity);
    List<SysCurrencyEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate);
    List<SysCurrencyEntity> getPageData(Integer start, Integer limit);
}

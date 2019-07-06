package com.hd.modules.sys.dao;

import com.hd.modules.sys.entity.SysCurrencyHistoryEntity;
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
public interface SysCurrencyHistoryDao {
    List<SysCurrencyHistoryEntity> getPageData(Integer start, Integer limit);
    List<SysCurrencyHistoryEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate);
}

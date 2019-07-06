package com.hd.modules.sys.service;


import com.hd.modules.sys.entity.SysCurrencyHistoryEntity;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/4 0004 下午 14:17
 * @description 币别资料业务接口
 * @params 
 * @return 
 */
public interface SysCurrencyHistoryService {
    List<SysCurrencyHistoryEntity> getPageData(Integer start, Integer limit);
    List<SysCurrencyHistoryEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate);
}

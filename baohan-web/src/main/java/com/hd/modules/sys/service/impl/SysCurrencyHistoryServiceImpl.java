package com.hd.modules.sys.service.impl;

import com.hd.modules.sys.dao.SysCurrencyHistoryDao;
import com.hd.modules.sys.entity.SysCurrencyHistoryEntity;
import com.hd.modules.sys.service.SysCurrencyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/4 0004 下午 14:19
 * @description 币别资料业务实现类
 * @params
 * @return
 */
@Service
public class SysCurrencyHistoryServiceImpl implements SysCurrencyHistoryService {

    @Autowired
    private SysCurrencyHistoryDao sysCurrencyHistoryDao;

    @Override
    public List<SysCurrencyHistoryEntity> getPageData(Integer pageIndex, Integer limit) {
        int start = 0;
        if(pageIndex > 1){
            start = (pageIndex-1)*10;
        }
        return sysCurrencyHistoryDao.getPageData(start,limit);
    }

    @Override
    public List<SysCurrencyHistoryEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate) {
        return sysCurrencyHistoryDao.currencySecForHistyor(name,nameEn,startDate,endDate);
    }

}

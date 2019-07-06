package com.hd.modules.sys.service.impl;

import com.hd.modules.sys.dao.SysCurrencyDao;
import com.hd.modules.sys.entity.SysCurrencyEntity;
import com.hd.modules.sys.service.SysCurrencyService;
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
public class SysCurrencyServiceImpl implements SysCurrencyService {

    @Autowired
    private SysCurrencyDao sysCurrencyDao;

    @Override
    public void currencyAdd(SysCurrencyEntity sysCurrencyEntity) {
        sysCurrencyDao.currencyAdd(sysCurrencyEntity);
    }

    @Override
    public void currencyDelById(Integer currencyId) {
        sysCurrencyDao.currencyDelById(currencyId);
    }

    @Override
    public void currencyEdit(SysCurrencyEntity sysCurrencyEntity) {
        sysCurrencyDao.currencyEdit(sysCurrencyEntity);
    }

    @Override
    public List<SysCurrencyEntity> currencySec(SysCurrencyEntity sysCurrencyEntity) {
        return sysCurrencyDao.currencySec(sysCurrencyEntity);
    }

    @Override
    public List<SysCurrencyEntity> currencySecForHistyor(String name, String nameEn, String startDate, String endDate) {
        return sysCurrencyDao.currencySecForHistyor(name,nameEn,startDate,endDate);
    }

    @Override
    public List<SysCurrencyEntity> getPageData(Integer pageIndex, Integer limit) {
        int start = 0;
        if(pageIndex > 1){
            start = (pageIndex-1)*10;
        }
        return sysCurrencyDao.getPageData(start, limit);
    }
}

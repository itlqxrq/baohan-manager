package com.hd.modules.frontcabinet.service.impl;

import com.hd.modules.frontcabinet.dao.ReceiptsDao;
import com.hd.modules.frontcabinet.entity.Customer;
import com.hd.modules.frontcabinet.entity.ManIfest;
import com.hd.modules.frontcabinet.service.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptsServiceImp implements ReceiptsService {

    @Autowired
    private ReceiptsDao receiptsDao;

    @Override
    public Customer queryCustomerByName(String cusCode) {
      return  receiptsDao.queryCustomerByName(cusCode);
    }

    @Override
    public void saveManIfest(ManIfest manIfest) {
        receiptsDao.saveManIfest(manIfest);
    }

    @Override
    public List<ManIfest> getGoodsPage(Integer pageIndex,Integer limit) {
        int start = 0;
        if(pageIndex > 1){
            start = (pageIndex-1)*10;
        }
        return receiptsDao.getGoodsPage(start,limit);

    }


}

package com.hd.modules.sys.service.impl;

import com.hd.modules.sys.dao.SysRoyaltyDao;
import com.hd.modules.sys.entity.SysRoyaltyEntity;
import com.hd.modules.sys.service.SysRoyaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/2 0002 上午 10:09
 * @description 提成点数业务实现类
 * @params
 * @return
 */
@Service
public class SysRoyaltyServiceImpl implements SysRoyaltyService {

    @Autowired
    private SysRoyaltyDao sysRoyaltyDao;

    @Override
    public void royaltyAdd(SysRoyaltyEntity sysRoyaltyEntity) {
        sysRoyaltyDao.royaltyAdd(sysRoyaltyEntity);
    }

    @Override
    public void royaltyDelById(Integer royaltyId) {
        sysRoyaltyDao.royaltyDelById(royaltyId);
    }

    @Override
    public void royaltyEdit(SysRoyaltyEntity sysRoyaltyEntity) {
        sysRoyaltyDao.royaltyEdit(sysRoyaltyEntity);
    }

    @Override
    public List<SysRoyaltyEntity> royaltySec(SysRoyaltyEntity sysRoyaltyEntity) {
        return sysRoyaltyDao.royaltySec(sysRoyaltyEntity);
    }

    @Override
    public List<SysRoyaltyEntity> getPageData(Integer pageIndex, Integer limit) {
        int start = 0;
        if(pageIndex > 1){
            start = (pageIndex-1)*10;
        }
        return sysRoyaltyDao.getPageData(start,limit);
    }
}

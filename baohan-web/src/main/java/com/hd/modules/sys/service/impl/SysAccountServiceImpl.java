package com.hd.modules.sys.service.impl;

import com.hd.modules.sys.dao.SysAccountDao;
import com.hd.modules.sys.entity.SysAccountEntity;
import com.hd.modules.sys.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAccountServiceImpl implements SysAccountService {

    @Autowired
    private SysAccountDao sysAccountDao;

    @Override
    public void accountAdd(SysAccountEntity sysAccountEntity) {
        sysAccountDao.accountAdd(sysAccountEntity);
    }

    @Override
    public void accountDelById(Integer accountId) {
        sysAccountDao.accountDelById(accountId);
    }

    @Override
    public void accountEdit(SysAccountEntity sysAccountEntity) {
        sysAccountDao.accountEdit(sysAccountEntity);
    }

    @Override
    public List<SysAccountEntity> getPageData() {
        return sysAccountDao.getPageData();
    }

    @Override
    public List<SysAccountEntity> accountSec(String name) {
        return sysAccountDao.accountSec(name);
    }
}

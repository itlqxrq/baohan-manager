package com.hd.modules.sys.service;

import com.hd.modules.sys.entity.SysAccountEntity;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/3 0003 下午 13:54
 * @description 会计科目业务类
 * @params
 * @return
 */
public interface SysAccountService {
    void accountAdd(SysAccountEntity sysAccountEntity);
    void accountDelById(Integer accountId);
    void accountEdit(SysAccountEntity sysAccountEntity);
    List<SysAccountEntity> getPageData();
    List<SysAccountEntity> accountSec(String name);
}

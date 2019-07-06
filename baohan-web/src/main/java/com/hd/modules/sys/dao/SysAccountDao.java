package com.hd.modules.sys.dao;

import com.hd.modules.sys.entity.SysAccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/3 0003 下午 13:47
 * @description 会计科目Dao
 * @params
 * @return
 */
@Mapper
@Component
public interface SysAccountDao {
    void accountAdd(SysAccountEntity sysAccountEntity);
    void accountDelById(Integer accountId);
    void accountEdit(SysAccountEntity sysAccountEntity);
    List<SysAccountEntity> getPageData();
    List<SysAccountEntity> accountSec(String name);
}
